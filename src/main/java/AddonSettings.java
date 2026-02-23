import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AddonSettings {
    private boolean enabled = true;
    private int volume = 80;
    private long announcementCooldownMs = 1500;
    private final Map<String, String> abilitySounds = new HashMap<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            this.volume = 0;
        } else if (volume > 100) {
            this.volume = 100;
        } else {
            this.volume = volume;
        }
    }

    public long getAnnouncementCooldownMs() {
        return announcementCooldownMs;
    }

    public void setAnnouncementCooldownMs(long announcementCooldownMs) {
        this.announcementCooldownMs = Math.max(0, announcementCooldownMs);
    }

    public String getSoundForAbility(String abilityName) {
        return abilitySounds.getOrDefault(abilityName.toLowerCase(), "default_alert.wav");
    }

    public void setSoundForAbility(String abilityName, String soundFileName) {
        abilitySounds.put(abilityName.toLowerCase(), soundFileName);
    }

    public Map<String, String> getAbilitySounds() {
        return Collections.unmodifiableMap(abilitySounds);
    }

    @Override
    public String toString() {
        return "AddonSettings{" +
                "enabled=" + enabled +
                ", volume=" + volume +
                ", announcementCooldownMs=" + announcementCooldownMs +
                ", abilitySounds=" + abilitySounds +
                '}';
    }
}
