package net.tahmeed.fabermod.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class DayLightSaverItem extends Item {
    public DayLightSaverItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            ServerLevel serverLevel = (ServerLevel) context.getLevel();
            Player player = context.getPlayer();

            // Change time to noon (6000 ticks)
            serverLevel.setDayTime(6000);


            if (player != null) {
                player.sendSystemMessage(Component.literal("World properties changed!"));
            }
        }

        // Damage the item after use
        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }
}
