package me.mabo.ra.blocks;

import me.mabo.ra.RecycleArmor;
import me.mabo.ra.tiles.TileRecycleFurnace;
import me.mabo.ra.util.handlers.GuiHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRecycleFurnace extends BlockContainer
{
    public BlockRecycleFurnace()
    {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    // Called when the block is placed or loaded client side to get the tile entity for the block
    // Should return a new instance of the tile entity for the block
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileRecycleFurnace();
    }

    // Called when the block is right clicked
    // In this block it is used to open the blocks gui when right clicked by a player
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
                                    EnumFacing side, float hitX, float hitY, float hitZ) {
        // Uses the gui handler registered to your mod to open the gui for the given gui id
        // open on the server side only  (not sure why you shouldn't open client side too... vanilla doesn't, so we better not either)
        if (worldIn.isRemote) return true;

        playerIn.openGui(RecycleArmor.instance, GuiHandler.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    // This is where you can do something when the block is broken. In this case drop the inventory's contents
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof IInventory) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileEntity);
        }

        // Super MUST be called last because it removes the tile entity
        super.breakBlock(worldIn, pos, state);
    }

    // update the block state depending on the number of slots which contain burning fuel
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof TileRecycleFurnace) {
            TileRecycleFurnace tileRecycleFurnace = (TileRecycleFurnace)tileEntity;
            int burningSlots = tileRecycleFurnace.numberOfBurningFuelSlots();
            burningSlots = MathHelper.clamp(burningSlots, 0, 4);
            return getDefaultState().withProperty(BURNING_SIDES_COUNT, burningSlots);
        }
        return state;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    // necessary to define which properties your blocks use
    // will also affect the variants listed in the blockstates model file.  See MBE03 for more info.
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BURNING_SIDES_COUNT});
    }

    public static final PropertyInteger BURNING_SIDES_COUNT = PropertyInteger.create("burning_sides_count", 0, 4);

    // change the furnace emitted light ("block light") depending on how many slots are burning
    private static final int FOUR_SIDE_LIGHT_VALUE = 15; // light value for four sides burning
    private static final int ONE_SIDE_LIGHT_VALUE = 8;  // light value for a single side burning

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        int lightValue = 0;
        IBlockState blockState = getActualState(getDefaultState(), world, pos);
        int burningSides = (Integer)blockState.getValue(BURNING_SIDES_COUNT);

        if (burningSides == 0) {
            lightValue = 0;
        } else {
            // linearly interpolate the light value depending on how many slots are burning
            lightValue = ONE_SIDE_LIGHT_VALUE + (int)((FOUR_SIDE_LIGHT_VALUE - ONE_SIDE_LIGHT_VALUE) / (4.0 - 1.0) * burningSides);
        }
        lightValue = MathHelper.clamp(lightValue, 0, FOUR_SIDE_LIGHT_VALUE);
        return lightValue;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public boolean isOpaqueCube(IBlockState iBlockState) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState iBlockState) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
        return EnumBlockRenderType.MODEL;
    }
}
