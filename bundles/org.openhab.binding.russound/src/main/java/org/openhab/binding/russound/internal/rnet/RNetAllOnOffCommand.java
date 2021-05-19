/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.russound.internal.rnet;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a byte string to turn all zones on or off
 *
 * @author Craig Hamilton
 *
 */
public class RNetAllOnOffCommand implements RNetCommand {
    private final Logger logger = LoggerFactory.getLogger(RNetAllOnOffCommand.class);
    private static byte[] allOffBytes = new byte[] { (byte) 0xf0, (byte) 0x7e, (byte) 0x00, (byte) 0x7f, (byte) 0x00,
            (byte) 0x00, (byte) 0x70, (byte) 0x05, (byte) 0x02, (byte) 0x02, (byte) 0x00, (byte) 0x00, (byte) 0xf1,
            (byte) 0x22, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01 };

    @Override
    public byte[] getCommand(ZoneId zoneId, byte value) {

        byte[] commandByteCopy = Arrays.copyOf(allOffBytes, allOffBytes.length);
        commandByteCopy[4] = (byte) (zoneId.getZoneId() - 1);
        commandByteCopy[5] = (byte) (zoneId.getControllerId() - 1);
        // if value is 1, let's set 16 to 1, if 0 set indice 15. MCA supports all on, CAV doesn't
        if (value == 1) {
            commandByteCopy[16] = 1;
        } else if (value == 0) {
            commandByteCopy[15] = 0;
        }
        logger.debug("getCommandReturning zone: {}, controller: {}, value: {}", zoneId.getZoneId(),
                zoneId.getControllerId(), value);
        logger.debug("Bytes: {}", commandByteCopy);
        return commandByteCopy;
    }
}
