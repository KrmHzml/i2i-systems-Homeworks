package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalTime;

public class myTimerLoggings {

    private static Logger logger = LogManager.getLogger(myTimerLoggings.class);

    public static void main(String[] args) throws InterruptedException {
        startLogging();
    }

    public static void startLogging() throws InterruptedException {
        while (true) {
            LocalTime currentTime = LocalTime.now(); // Şu anki zamanı alıyor
            Thread.sleep(1000); // 1 saniye bekletiliyor
            LocalTime updatedTime = LocalTime.now(); // Güncel zamanı alıyor

            if (currentTime.getHour() != updatedTime.getHour()) {
                logger.error(getTime(updatedTime)); // Eğer saat değişmişse error seviyesinde loglama yapılıyor
            } else if (currentTime.getMinute() != updatedTime.getMinute()) {
                logger.info(getTime(updatedTime)); // Eğer dakika değişmişse info seviyesinde loglama yapılıyor
            } else if (currentTime.getSecond() != updatedTime.getSecond()) {
                logger.debug(getTime(updatedTime)); // Eğer saniye değişmişse debug seviyesinde loglama yapılıyor
            }
        }
    }

    public static String getTime(LocalTime time) {
        return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond(); // Saat, dakika ve saniye değerlerini birleştirerek string olarak döndürüyor
    }
}
