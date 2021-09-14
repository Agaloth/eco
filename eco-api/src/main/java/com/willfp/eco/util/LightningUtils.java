package com.willfp.eco.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/**
 * Utilities / API methods for lightning.
 */
@UtilityClass
public class LightningUtils {

    /**
     * Strike lightning on player without fire.
     *
     * @param victim The entity to smite.
     * @param damage The damage to deal.
     * @param silent If the lightning sound should be played locally
     */
    public void strike(@NotNull final LivingEntity victim,
                       final double damage,
                       final boolean silent) {
        Location loc = victim.getLocation();

        if (silent) {
            victim.getWorld().spigot().strikeLightningEffect(loc, true);
            victim.getWorld().playSound(loc, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, 1);
        } else {
            victim.getWorld().strikeLightningEffect(loc);
        }

        victim.damage(damage);
    }

    /**
     * Strike lightning on a victim without fire.
     *
     * @param victim The entity to smite.
     * @param damage The damage to deal.
     */
    public void strike(@NotNull final LivingEntity victim,
                       final double damage) {
        strike(victim, damage, false);
    }
}
