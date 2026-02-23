import java.util.HashMap;
import java.util.Map;

public class TargetAbilitySoundAddon {
    private final AddonSettings settings = new AddonSettings();
    private final Map<String, Long> lastAnnouncementTime = new HashMap<>();

    public TargetAbilitySoundAddon() {
        settings.setSoundForAbility("blink", "alert_blink.wav");
        settings.setSoundForAbility("stun", "alert_stun.wav");
        settings.setSoundForAbility("ultimate", "alert_ultimate.wav");
    }

    public AddonSettings getSettings() {
        return settings;
    }

    public void handleTargetAbility(String targetName, String abilityName) {
        if (!settings.isEnabled()) {
            System.out.println("[addon] Звуковые анонсы отключены.");
            return;
        }

        long now = System.currentTimeMillis();
        String key = targetName.toLowerCase() + ":" + abilityName.toLowerCase();
        Long last = lastAnnouncementTime.get(key);

        if (last != null && now - last < settings.getAnnouncementCooldownMs()) {
            System.out.println("[addon] Анонс пропущен из-за cooldown.");
            return;
        }

        String sound = settings.getSoundForAbility(abilityName);
        System.out.println("[addon] Таргет " + targetName + " использовал " + abilityName
                + ". Воспроизведение: " + sound + " (громкость " + settings.getVolume() + "%).");

        lastAnnouncementTime.put(key, now);
    }
}
