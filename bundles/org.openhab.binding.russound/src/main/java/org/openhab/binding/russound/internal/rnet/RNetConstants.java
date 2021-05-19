/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.russound.internal.rnet;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openhab.binding.russound.internal.RussoundBindingConstants;
import org.openhab.core.thing.ThingTypeUID;

/**
 * Constants used for RNet support
 * 
 * @author Craig Hamilton
 *
 */
public class RNetConstants {

    public final static ThingTypeUID BRIDGE_TYPE_RNET = new ThingTypeUID(RussoundBindingConstants.BINDING_ID, "rnet");
    public final static ThingTypeUID BRIDGE_TYPE__RNET_CONTROLLER = new ThingTypeUID(
            RussoundBindingConstants.BINDING_ID, "rnetcontroller");
    public final static ThingTypeUID THING_TYPE_RNET_ZONE = new ThingTypeUID(RussoundBindingConstants.BINDING_ID,
            "rnetzone");

    public static final Set<ThingTypeUID> SUPPORTED_DEVICE_THING_TYPES_UIDS = Collections
            .unmodifiableSet(Stream.of(BRIDGE_TYPE_RNET, THING_TYPE_RNET_ZONE).collect(Collectors.toSet()));

    public static final String CHANNEL_SYSALLON = "allon";
    public static final String CHANNEL_SYSALLOFF = "alloff";

    public static final String CHANNEL_ZONESOURCE = "source";
    public static final String CHANNEL_ZONEVOLUME = "volume";
    public static final String CHANNEL_ZONESTATUS = "status";
    public static final String CHANNEL_ZONEBALANCE = "balance";
    public static final String CHANNEL_ZONELOUDNESS = "loudness";
    public static final String CHANNEL_ZONETREBLE = "treble";
    public static final String CHANNEL_ZONEBASS = "bass";
    public static final String CHANNEL_ZONEMUTE = "mute";
    public static final String CHANNEL_ZONETURNONVOLUME = "turnonvolume";

    public final static String THING_PROPERTIES_CONTROLLER = "controller";
    public final static String THING_PROPERTIES_ZONE = "zone";
}
