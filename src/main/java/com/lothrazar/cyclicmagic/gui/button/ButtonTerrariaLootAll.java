package com.lothrazar.cyclicmagic.gui.button;

import com.lothrazar.cyclicmagic.ModMain;
import com.lothrazar.cyclicmagic.net.PacketDepositContainerToPlayer;
import com.lothrazar.cyclicmagic.util.Const;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ButtonTerrariaLootAll extends GuiButton {
	public ButtonTerrariaLootAll(int buttonId, int x, int y) {
		super(buttonId, x, y, Const.btnWidth, Const.btnHeight, I18n.format("button.terraria.lootall"));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
		boolean pressed = super.mousePressed(mc, mouseX, mouseY);

		if (pressed) {
			ModMain.network.sendToServer(new PacketDepositContainerToPlayer(new NBTTagCompound()));
		}

		return pressed;
	}
}