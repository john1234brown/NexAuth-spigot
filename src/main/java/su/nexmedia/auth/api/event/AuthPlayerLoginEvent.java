package su.nexmedia.auth.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.dblockbuster.BungeeSender;
import com.dblockbuster.MessageType;

import su.nexmedia.auth.NexAuth;
import su.nexmedia.auth.data.impl.AuthUser;

public class AuthPlayerLoginEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player   player;
    private final AuthUser user;
    private final BungeeSender messageSender;

    public AuthPlayerLoginEvent(boolean async, @NotNull Player player, @NotNull AuthUser user, NexAuth plugin) {
        super(async);
        this.player = player;
        this.user = user;
        this.messageSender = plugin.getMessageSender();
        messageSender.sendMessageToBungee("mySubChannel", player.getName());
        //messageSender.sendMessageToProxy(player, MessageType.LOGIN, player.getName());
//        messageSender.sendMessageToBungee(player.getName(), getEventName(), getEventName());
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public AuthUser getUser() {
        return user;
    }

    @Override
    @NotNull
    public final HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
