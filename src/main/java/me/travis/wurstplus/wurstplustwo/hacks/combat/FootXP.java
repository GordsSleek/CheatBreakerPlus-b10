/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemExpBottle
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 */
package me.travis.wurstplus.wurstplustwo.hacks.combat;

import java.util.function.Predicate;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;

public class FootXP
extends WurstplusHack {
    @EventHandler
    public Listener<WurstplusEventPacket.SendPacket> listener;

    public FootXP() {
        super(WurstplusCategory.WURSTPLUS_COMBAT);
        this.name = "Feet Experience";
        this.tag = "FeetExperience";
        this.description = "Throw xp to your feet";
        this.listener = new Listener<WurstplusEventPacket.SendPacket>(event -> {
            if (event.get_packet() instanceof CPacketPlayerTryUseItem) {
                if (FootXP.mc.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle) {
                    FootXP.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(FootXP.mc.player.rotationYaw, 90.0f, FootXP.mc.player.onGround));
                }
            }
        }, new Predicate[0]);
    }
}

