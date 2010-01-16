/*
    AO-XP Server (XP stands for Cross Platform) is a Java implementation of Argentum Online's server 
    Copyright (C) 2009 Juan Martín Sotuyo Dodero. <juansotuyo@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package ao.network.packet.incoming;

import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;

import ao.context.ApplicationContext;
import ao.model.user.ConnectedUser;
import ao.network.Connection;
import ao.network.DataBuffer;
import ao.network.ServerPacketsManager;
import ao.network.packet.IncomingPacket;
import ao.network.packet.outgoing.ErrorMessagePacket;
import ao.security.Hashing;
import ao.service.LoginService;
import ao.service.login.LoginErrorException;

public class LoginExistingCharacterPacket implements IncomingPacket {

	private static LoginService service = ApplicationContext.getInstance(LoginService.class);
	
	@Override
	public void handle(Connection connection) throws BufferUnderflowException, UnsupportedEncodingException {
		DataBuffer buffer = connection.getInputBuffer();
		
		String username = buffer.getASCIIString();
		
		String password;
		
		if (ApplicationContext.SECURITY_ENABLED) {
			password = buffer.getASCIIStringFixed(Hashing.MD5_ASCII_LENGTH);
		} else {
			password = buffer.getASCIIString();
		}
		
		String version = buffer.getShort() + "." + buffer.getShort() + "." + buffer.getShort();
		String clientHash = "";
		
		if (ApplicationContext.SECURITY_ENABLED) {
			clientHash = buffer.getASCIIStringFixed(Hashing.MD5_BINARY_LENGTH);
		}
		
		try {
			service.connectExistingCharacter((ConnectedUser) connection.getUser(), username, password, version, clientHash);
		} catch(LoginErrorException e) {
			loginError(connection, e.getMessage());
		}
		
	}

	/**
	 * Notifies the client about the error and closes the connection.
	 * @param connection The connection where the login error has occurred.
	 * @param cause 	 The error cause.
	 * @throws UnsupportedEncodingException
	 */
	private void loginError(Connection connection, String cause) throws UnsupportedEncodingException {
		ServerPacketsManager.write(new ErrorMessagePacket(cause), connection.getOutputBuffer());
		connection.disconnect();
	}

}
