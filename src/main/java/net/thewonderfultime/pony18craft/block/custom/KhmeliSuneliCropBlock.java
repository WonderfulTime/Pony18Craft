package net.thewonderfultime.pony18craft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.thewonderfultime.pony18craft.Item.ModItems;

public class KhmeliSuneliCropBlock extends CropBlock {

    public static final IntProperty AGE = IntProperty.of("age", 0, 4);
    public KhmeliSuneliCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.KHMELI_SUNELI_SEEDS;
    }

    @Override
    public int getMaxAge(){

        return 4;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }



}
