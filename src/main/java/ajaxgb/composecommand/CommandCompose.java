package ajaxgb.composecommand;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;

import com.google.gson.JsonParseException;

public class CommandCompose extends CommandBase {

	@Override
	public String getName() {
		return "compose";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.compose.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length < 1) {
			throw new WrongUsageException("commands.compose.usage");
		}

		String s = buildString(args, 0);
		ITextComponent textComponent;

		try {
			textComponent = ITextComponent.Serializer.jsonToComponent(s);
			textComponent = TextComponentUtils.processComponent(sender, textComponent, null);
		} catch (JsonParseException e) {
			throw toSyntaxException(e);
		}
		
		server.getCommandManager().executeCommand(sender, textComponent.getUnformattedText());
	}

}
