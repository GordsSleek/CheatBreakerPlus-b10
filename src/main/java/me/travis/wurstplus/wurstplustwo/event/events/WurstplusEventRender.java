/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.util.math.Vec3d
 */
package me.travis.wurstplus.wurstplustwo.event.events;

import me.travis.wurstplus.wurstplustwo.event.WurstplusEventCancellable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.Vec3d;

public class WurstplusEventRender
extends WurstplusEventCancellable {
    private final ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
    private final Tessellator tessellator;
    private final Vec3d render_pos;

    public WurstplusEventRender(Tessellator tessellator, Vec3d pos) {
        this.tessellator = tessellator;
        this.render_pos = pos;
    }

    public Tessellator get_tessellator() {
        return this.tessellator;
    }

    public Vec3d get_render_pos() {
        return this.render_pos;
    }

    public BufferBuilder get_buffer_build() {
        return this.tessellator.getBuffer();
    }

    public void set_translation(Vec3d pos) {
        this.get_buffer_build().setTranslation(-pos.x, -pos.y, -pos.z);
    }

    public void reset_translation() {
        this.set_translation(this.render_pos);
    }

    public double get_screen_width() {
        return this.res.getScaledWidth_double();
    }

    public double get_screen_height() {
        return this.res.getScaledHeight_double();
    }
}

