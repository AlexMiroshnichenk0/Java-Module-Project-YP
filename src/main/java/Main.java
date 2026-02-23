import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TargetAbilitySoundAddon addon = new TargetAbilitySoundAddon();

        System.out.println("Аддон звукового анонса способностей таргета запущен.");
        printHelp();

        while (true) {
            System.out.print("> ");
            String command = scanner.next().trim().toLowerCase();

            switch (command) {
                case "help":
                    printHelp();
                    break;
                case "status":
                    System.out.println(addon.getSettings());
                    break;
                case "toggle":
                    addon.getSettings().setEnabled(!addon.getSettings().isEnabled());
                    System.out.println("Звуковой анонс: " + (addon.getSettings().isEnabled() ? "ВКЛ" : "ВЫКЛ"));
                    break;
                case "volume":
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка: укажите значение громкости от 0 до 100");
                        scanner.next();
                        break;
                    }
                    int volume = scanner.nextInt();
                    addon.getSettings().setVolume(volume);
                    System.out.println("Громкость изменена: " + addon.getSettings().getVolume() + "%");
                    break;
                case "cooldown":
                    if (!scanner.hasNextLong()) {
                        System.out.println("Ошибка: укажите cooldown в миллисекундах");
                        scanner.next();
                        break;
                    }
                    long cooldownMs = scanner.nextLong();
                    addon.getSettings().setAnnouncementCooldownMs(cooldownMs);
                    System.out.println("Cooldown изменен: " + addon.getSettings().getAnnouncementCooldownMs() + "ms");
                    break;
                case "announce":
                    String targetName = scanner.next();
                    String abilityName = scanner.next();
                    addon.handleTargetAbility(targetName, abilityName);
                    break;
                case "sound":
                    String abilityToConfigure = scanner.next();
                    String soundName = scanner.next();
                    addon.getSettings().setSoundForAbility(abilityToConfigure, soundName);
                    System.out.println("Для способности '" + abilityToConfigure + "' установлен звук '" + soundName + "'.");
                    break;
                case "exit":
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неизвестная команда. Введите help.");
            }
        }
    }

    private static void printHelp() {
        System.out.println("Команды:");
        System.out.println("  help                        - показать команды");
        System.out.println("  status                      - текущее состояние настроек");
        System.out.println("  toggle                      - включить/выключить анонс");
        System.out.println("  volume <0..100>             - установить громкость");
        System.out.println("  cooldown <ms>               - установить задержку между анонсами");
        System.out.println("  sound <ability> <sound>     - назначить звук для способности");
        System.out.println("  announce <target> <ability> - имитировать использование способности");
        System.out.println("  exit                        - выход");
    }
}
