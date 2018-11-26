package me.mabo.ra.util.handlers;

import me.mabo.ra.container.ContainerRecycleFurnace;
import me.mabo.ra.gui.GuiRecycleFurnace;
import me.mabo.ra.tiles.TileRecycleFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    private static final int GUUID_RA = 97;
    public static int getGuiID() {return GUUID_RA;}

    // Gets the server side element for the given gui id this should return a container
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileRecycleFurnace) {
            TileRecycleFurnace tileRecycleFurnace = (TileRecycleFurnace) tileEntity;
            return new ContainerRecycleFurnace(player.inventory, tileRecycleFurnace);
        }
        return null;
    }

    // Gets the client side element for the given gui id this should return a gui
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileRecycleFurnace) {
            TileRecycleFurnace tileRecycleFurnace = (TileRecycleFurnace) tileEntity;
            return new GuiRecycleFurnace(player.inventory, tileRecycleFurnace);
        }
        return null;
    }
}
