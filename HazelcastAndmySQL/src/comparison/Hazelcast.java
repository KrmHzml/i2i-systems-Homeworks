package comparison;

import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Hazelcast {
    // Hazelcast istemci oluşturuyoruz
    static HazelcastInstance hz = HazelcastClient.newHazelcastClient();
    static IMap<Integer, Integer> map = hz.getMap("Example");

    // Belirtilen boyutta veri ekleyip süreyi ölçüyoruz.
    public static void putDataToHazel(int dataSize) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= dataSize; i++) {
            int randomNumber = (int) Math.ceil(Math.random()*5);
            map.put(i, randomNumber);
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Hazelcast " + dataSize + " veri ekleme süresi: " + totalTime + "ms");
    }

    // Belirtilen boyutta veriyi alıp süreyi ölçüyoruz.
    public static void getDataFromHazel(int dataSize) {
        long startTime = System.currentTimeMillis();
        for (Entry<Integer, Integer> entry : map.entrySet()) {  }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Hazelcast " + dataSize + " veri alma süresi: " + totalTime + "ms");
    }

}

