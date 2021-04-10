package org.profile.volat;

import org.openjdk.jol.info.ClassLayout;

public class jolTest {
    public static void main(String[] args) {
        Object o=new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        //执行这段代码时，锁定了o对象(锁的是房间的门，不是房间)
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
