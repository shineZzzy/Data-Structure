package org.profile.volat;

import org.openjdk.jol.info.ClassLayout;

import java.nio.ByteOrder;

public class Valid {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ByteOrder.nativeOrder().toString());

        User user = new User();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());

        synchronized (user) {
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }

        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }
}
