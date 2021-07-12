package me.kingili.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static class ConfigHandler {
        public static Configuration config;
        private final static String file = "config/kingtils.cfg";

        public static void init() {
            config = new Configuration(new File(file));
            try {
                config.load();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                config.save();
            }
        }

        public static String getString(String category, String key) {
            config = new Configuration(new File(file));
            try {
                config.load();
                if (config.getCategory(category).containsKey(key)) {
                    return config.get(category, key, "").getString();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                config.save();
            }
            return "";
        }

        public static void writeIntConfig(String category, String key, int value) {
            config = new Configuration(new File(file));
            try {
                config.load();
                int set = config.get(category, key, value).getInt();
                config.getCategory(category).get(key).set(value);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                config.save();
            }
        }

        public static int getInt(String category, String key) {
            config = new Configuration(new File(file));
            config = new Configuration(new File(file));
            try {
                config.load();
                if (config.getCategory(category).containsKey(key)) {
                    return config.get(category, key, 1).getInt();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                config.save();
            }
            return 1;
        }

        public static void writeStringConfig(String category, String key, String value) {
            config = new Configuration(new File(file));
            try {
                config.load();
                String set = config.get(category, key, value).getString();
                config.getCategory(category).get(key).set(value);
            } catch (Exception ex) {
                System.err.println(category + " : " + key + " : " + value);
                ex.printStackTrace();
            } finally {
                config.save();
            }
        }
    }
}
