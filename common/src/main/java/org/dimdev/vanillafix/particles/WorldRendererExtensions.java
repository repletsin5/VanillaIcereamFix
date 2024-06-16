package org.dimdev.vanillafix.particles;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;

public interface WorldRendererExtensions {

	static void renderIfVisible(Particle particle, VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
		if(MinecraftClient.getInstance().worldRenderer.frustum.isVisible(particle.getBoundingBox())) {
			particle.buildGeometry(vertexConsumer, camera, tickDelta);
		}
	}
}
