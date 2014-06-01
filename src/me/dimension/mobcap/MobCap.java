package me.dimension.mobcap;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class MobCap
        extends JavaPlugin
        implements Listener {

    private String prefix = ChatColor.BLUE + "[Mob Cap] ";
    public static final Logger log = Logger.getLogger("Minecraft");
    public ArrayList<String> playercap = new ArrayList<String>();

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        PluginDescriptionFile pdfFile = getDescription();
        log.info(this.prefix + "version v" + pdfFile.getVersion() + " is enabled.");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerDamageEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getEntity().getPassenger() == null) {
            } else {
                if (event.getDamager() == event.getEntity().getPassenger()) {
                    event.setDamage(0.0D);
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void playerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (playercap.contains(player.getPlayerListName())) {


            if ((event.getRightClicked() instanceof Chicken)) {
                if (player.hasPermission("mobcap.passive.chicken")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping chicken cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your chicken cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Zombie)) {
                if (player.hasPermission("mobcap.hostile.zombie")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping zombie cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping zombie cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Snowman)) {
                if (player.hasPermission("mobcap.passive.snowman")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your snow golem cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your snow golem cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Cow)) {
                if (player.hasPermission("mobcap.passive.cow")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your cow cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your cow cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Bat)) {
                if (player.hasPermission("mobcap.passive.bat")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your bat cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping you bat cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Ocelot)) {
                if (player.hasPermission("mobcap.passive.ocelot")) {
                    Ocelot ocelot = (Ocelot) event.getRightClicked();
                    if (ocelot.getOwner() == null) {
                    } else {
                        if (player.hasPermission("mobcap.multi")) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    removeHats((Entity) player);
                                } else {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your ocelot cap.");
                                    getTopHat((Entity) player).setPassenger(event.getRightClicked());
                                }
                            }
                        } else {
                            if (ocelot.getOwner().getName().equals(player.getName())) {
                                if (player.getPassenger() == null) {
                                    if (player.getItemInHand().getType() == Material.AIR) {
                                        event.setCancelled(true);
                                        player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your ocelot cap.");
                                        player.setPassenger(event.getRightClicked());
                                    }
                                } else if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    player.eject();
                                }
                            }
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Villager)) {
                if (player.hasPermission("mobcap.passive.villager")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your villager cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                event.setCancelled(true);
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping villager cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Wolf)) {
                if (player.hasPermission("mobcap.passive.wolf")) {
                    Wolf wolf = (Wolf) event.getRightClicked();
                    if (wolf.getOwner() == null) {
                    } else {
                        if (player.hasPermission("mobcap.multi")) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    removeHats((Entity) player);
                                } else {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your wolf cap.");
                                    getTopHat((Entity) player).setPassenger(event.getRightClicked());
                                }
                            }
                        } else {
                            if (wolf.getOwner().getName().equals(player.getName())) {
                                if (player.getPassenger() == null) {
                                    if (player.getItemInHand().getType() == Material.AIR) {
                                        event.setCancelled(true);
                                        player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your wolf cap.");
                                        player.setPassenger(event.getRightClicked());
                                    }
                                } else if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    player.eject();
                                }
                            }
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof MushroomCow)) {
                if (player.hasPermission("mobcap.passive.mooshroom")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your mooshroom cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping mooshroom cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Horse)) {
                if (player.hasPermission("mobcap.passive.horse")) {
                    Horse horse = (Horse) event.getRightClicked();
                    if (horse.getOwner() == null) {
                    } else {
                        if (player.hasPermission("mobcap.multi")) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    removeHats((Entity) player);
                                } else {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your horse cap.");
                                    getTopHat((Entity) player).setPassenger(event.getRightClicked());
                                }
                            }
                        } else {
                            if (horse.getOwner().getName().equals(player.getName())) {
                                if (player.getPassenger() == null) {
                                    if (player.getItemInHand().getType() == Material.AIR) {
                                        event.setCancelled(true);
                                        player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your horse cap.");
                                        player.setPassenger(event.getRightClicked());
                                    }
                                } else if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    player.eject();
                                }
                            }
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Sheep)) {
                if (player.hasPermission("mobcap.passive.sheep")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your sheep cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your sheep cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Pig)) {
                if (player.hasPermission("mobcap.passive.pig")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your pig cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your pig cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Squid)) {
                if (player.hasPermission("mobcap.passive.squid")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your squid cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping our squid cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof IronGolem)) {
                if (player.hasPermission("mobcap.passive.irongolem")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your iron golem cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your iron golem cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Skeleton)) {
                Skeleton skeleton = (Skeleton) event.getRightClicked();
                if (skeleton.getSkeletonType() == SkeletonType.NORMAL) {
                    if (player.hasPermission("mobcap.hostile.skeleton")) {
                        if (player.hasPermission("mobcap.multi")) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    removeHats((Entity) player);
                                } else {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your skeleton cap.");
                                    getTopHat((Entity) player).setPassenger(event.getRightClicked());
                                }
                            }
                        } else {
                            if (player.getPassenger() == null) {
                                if (player.getItemInHand().getType() == Material.AIR) {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping you skeleton cap.");
                                    player.setPassenger(event.getRightClicked());
                                }
                            } else if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                player.eject();
                            }
                        }
                    }
                } else if (skeleton.getSkeletonType() == SkeletonType.WITHER) {
                    if (player.hasPermission("mobcap.hostile.witherskeleton")) {
                        if (player.hasPermission("mobcap.multi")) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                if (event.getRightClicked().equals(player.getPassenger())) {
                                    player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                    removeHats((Entity) player);
                                } else {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your wither skeleton cap.");
                                    getTopHat((Entity) player).setPassenger(event.getRightClicked());
                                }
                            }
                        } else {
                            if (player.getPassenger() == null) {
                                if (player.getItemInHand().getType() == Material.AIR) {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your wither skeleton cap.");
                                    player.setPassenger(event.getRightClicked());
                                }
                            } else if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                player.eject();
                            }
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Spider)) {
                if (player.hasPermission("mobcap.hostile.spider")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your spider cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your spider cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
            if ((event.getRightClicked() instanceof Blaze)) {
                if (player.hasPermission("mobcap.hostile.blaze")) {
                    if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                removeHats((Entity) player);
                            } else {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your blaze cap.");
                                getTopHat((Entity) player).setPassenger(event.getRightClicked());
                            }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping blaze cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
            }
                if ((event.getRightClicked() instanceof CaveSpider)) {
                    if (player.hasPermission("mobcap.hostile.cavespider")) {
                        if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your cave spider cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping you cave spider cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
                }
                if ((event.getRightClicked() instanceof Ghast)) {
                    if (player.hasPermission("mobcap.hostile.ghast")) {
                         if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your ghast cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your ghast cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
                }
                if ((event.getRightClicked() instanceof Silverfish)) {
                    if (player.hasPermission("mobcap.hostile.silverfish")) {
                        if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your silverfish cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your silverfish cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
                }
                if ((event.getRightClicked() instanceof Slime)) {
                    if (player.hasPermission("mobcap.hostile.slime")) {
                      if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your slime cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                            if (player.getPassenger() == null) {
                                if (player.getItemInHand().getType() == Material.AIR) {
                                    player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping slime cap.");
                                    player.setPassenger(event.getRightClicked());
                                }
                            } else if (event.getRightClicked().equals(player.getPassenger())) {
                                player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                                player.eject();
                            }
                      }
                    }
                }
                if ((event.getRightClicked() instanceof MagmaCube)) {
                    if (player.hasPermission("mobcap.hostile.magmacube")) {
                        if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your magma cube cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping magma cube cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                    }
                    }
                if ((event.getRightClicked() instanceof Witch)) {
                    if (player.hasPermission("mobcap.hostile.witch")) {
                        if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your ghast cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your witch cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
                }
                if ((event.getRightClicked() instanceof PigZombie)) {
                    if (player.hasPermission("mobcap.hostile.pigman")) {
                        if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your pig man cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your pig man cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
                }
                if ((event.getRightClicked() instanceof Enderman)) {
                    if (player.hasPermission("mobcap.hostile.enderman")) {
                        if (player.hasPermission("mobcap.multi")) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            removeHats((Entity)player);
                        } else{
                            player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your enderman cap.");
                            getTopHat((Entity) player).setPassenger(event.getRightClicked());
                        }
                        }
                    } else {
                        if (player.getPassenger() == null) {
                            if (player.getItemInHand().getType() == Material.AIR) {
                                player.sendMessage(this.prefix + ChatColor.GREEN + "Equipping your enderman cap.");
                                player.setPassenger(event.getRightClicked());
                            }
                        } else if (event.getRightClicked().equals(player.getPassenger())) {
                            player.sendMessage(this.prefix + ChatColor.RED + "Unequpping your Mob Cap.");
                            player.eject();
                        }
                    }
                }
                }
            }
        }

    

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mobcap")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
            } else {
                Player player = (Player) sender;
                if (playercap.contains(player.getPlayerListName())) {
                    player.sendMessage(prefix + ": You can no longer equip mobs as hats!");
                    playercap.remove(player.getPlayerListName());
                    if (player.getPassenger() == null) {
                    } else {
                        removeHats((Entity) player);
                    }
                } else {
                    playercap.add(player.getPlayerListName());
                    player.sendMessage(prefix + ": You can now equip mobs as hats!");
                }
            }
            return true;
        }
        return false;
    }

    public Entity getTopHat(Entity entity) {
        if (entity.getPassenger() == null) {
            return entity;
        } else {
            return getTopHat(entity.getPassenger());
        }
    }

    public void removeHats(Entity entity) {
        if (entity.getPassenger() == null) {
        } else {
            removeHats(entity.getPassenger());
            entity.eject();
        }
    }
}