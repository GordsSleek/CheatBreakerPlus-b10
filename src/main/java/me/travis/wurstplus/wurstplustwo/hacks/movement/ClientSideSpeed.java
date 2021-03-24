/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 */
package me.travis.wurstplus.wurstplustwo.hacks.movement;

import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ClientSideSpeed
extends WurstplusHack {
    WurstplusSetting speed = this.create("Speed", "CSPSpeed", 1, 0, 5);

    public ClientSideSpeed() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);
        this.name = "Client Side Speed";
        this.tag = "ClientSideSpeed";
        this.description = "gives speed potion effect client side";
    }

    @Override
    public void enable() {
        PotionEffect effect = new PotionEffect(Potion.getPotionById((int)1), 123456789, this.speed.get_value(1));
        effect.setPotionDurationMax(true);
        ClientSideSpeed.mc.player.addPotionEffect(effect);
    }

    @Override
    public void disable() {
        ClientSideSpeed.mc.player.removePotionEffect(Potion.getPotionById((int)1));
    }
}

