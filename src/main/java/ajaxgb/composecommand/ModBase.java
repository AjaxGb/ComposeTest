package ajaxgb.composecommand;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ModBase.MODID, version = ModBase.VERSION)
public class ModBase {

	public static final String MODID = "composecommand";
	public static final String VERSION = "1.0";

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandCompose());
	}
}
