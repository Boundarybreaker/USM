package space.bbkr.usm.block;

import org.jetbrains.annotations.Nullable;
import space.bbkr.usm.block.entity.LowPressureBoilerBlockEntity;
import space.bbkr.usm.registry.USMComponents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LowPressureBoilerBlock extends Block implements BlockEntityProvider {
	public LowPressureBoilerBlock(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			BlockEntity be = world.getBlockEntity(pos);
			if (be instanceof LowPressureBoilerBlockEntity) {
				player.sendMessage(new LiteralText("current steam: " + USMComponents.STEAM.get(be).getCalories()), true);
				return ActionResult.SUCCESS;
			}
		}
		return super.onUse(state, world, pos, player, hand, hit);
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new LowPressureBoilerBlockEntity();
	}
}
