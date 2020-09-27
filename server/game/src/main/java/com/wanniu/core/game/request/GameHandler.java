package com.wanniu.core.game.request;

import com.wanniu.core.GGame;
import com.wanniu.core.tcp.protocol.NetHandler;


public abstract class GameHandler
        extends NetHandler {
    public static class Watcher {
        public String handlerName;
        public int upcount;
        public int downcount;
        public long upbytes;
        public long downbytes;
        public int useTime;
        public long beginTime;

        public void begin(int byteCount) {
            if (GGame.MONITOR) {
                this.upbytes += byteCount;
                this.upbytes += 4L;
                this.upcount++;
                this.beginTime = System.currentTimeMillis();
            }
        }

        public void end(int byteCount) {
            if (GGame.MONITOR) {
                this.downbytes += byteCount;
                this.downcount++;
                this.useTime = (int) (this.useTime + System.currentTimeMillis() - this.beginTime);
            }
        }

        public float avgtime() {
            if (this.upcount == 0) return this.upcount;
            return this.useTime / this.upcount;
        }

        public void echo() {
            if (this.upcount != 0) {

                System.out.println(toString());
            }
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("\t").append(this.handlerName).append(" : { up:").append(this.upcount).append("/").append(this.upbytes).append(" , down:")
                    .append(this.downcount).append("/").append(this.downbytes).append(", avg:").append(avgtime()).append("/").append(this.useTime).append(" }");
            return builder.toString();
        }
    }


    public final Watcher watcher = new Watcher();
}


