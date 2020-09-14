/*
 *       Copyright (C) 2018-present Hyperium <https://hyperium.cc/>
 *
 *       This program is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published
 *       by the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       This program is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hyperiumjailbreak;

import cc.hyperium.Hyperium;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.network.server.ServerJoinEvent;
import cc.hyperium.event.network.server.ServerLeaveEvent;
import cc.hyperium.event.network.server.SingleplayerJoinEvent;
import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.entities.RichPresence;
import net.minecraft.client.Minecraft;

import java.time.OffsetDateTime;

public class RPCUpdater {

    private final IPCClient client;

    RPCUpdater(IPCClient client) {
        this.client = client;

        if (!MiniRPCSettings.DISCORD_RP) return;

        RichPresence.Builder builder = new RichPresence.Builder();

        client.sendRichPresence(builder
            .setSmallImage("compass")
            .setLargeImage("hyperium", "HyperiumJB")
            .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
            .setDetails("On the main menu")
            .setStartTimestamp(OffsetDateTime.now())
            .build());
    }

    @InvokeEvent
    public void joinServer(ServerJoinEvent event) {
        if (!MiniRPCSettings.DISCORD_RP) return;

        RichPresence.Builder builder = new RichPresence.Builder();

        client.sendRichPresence(Hyperium.INSTANCE.getHandlers().getHypixelDetector().isHypixel() ?
            builder
                .setSmallImage("compass")
                .setLargeImage("16", "Hypixel")
                .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                .setDetails("In the lobby on Hypixel")
                .setStartTimestamp(OffsetDateTime.now())
                .build() :
            builder
                .setSmallImage("compass")
                .setLargeImage("16", "On a server")
                .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                .setDetails("On a Minecraft server")
                .setStartTimestamp(OffsetDateTime.now())
                .build());
    }

    @InvokeEvent
    public void joinSingleplayer(SingleplayerJoinEvent event) {
        if (!MiniRPCSettings.DISCORD_RP) return;

        RichPresence.Builder builder = new RichPresence.Builder();

        client.sendRichPresence(builder
            .setSmallImage("compass")
            .setLargeImage("hyperium", "HyperiumJB")
            .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
            .setDetails("Playing Singleplayer")
            .setStartTimestamp(OffsetDateTime.now())
            .build());
    }

    @InvokeEvent
    public void leaveServer(ServerLeaveEvent event) {
        if (!MiniRPCSettings.DISCORD_RP) return;

        RichPresence.Builder builder = new RichPresence.Builder();

        client.sendRichPresence(builder
            .setSmallImage("compass")
            .setLargeImage("hyperium", "HyperiumJB")
            .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
            .setDetails("On the main menu")
            .setStartTimestamp(OffsetDateTime.now())
            .build());
    }
}
