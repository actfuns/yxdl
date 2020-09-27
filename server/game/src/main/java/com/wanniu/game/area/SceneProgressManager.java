package com.wanniu.game.area;

import com.wanniu.game.common.Const;
import com.wanniu.game.task.TaskEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SceneProgressManager {
    public Map<Integer, Object> progress = null;

    public SceneProgressManager(Map<Integer, Object> data) {
        this.progress = data;
    }

    public void onEvent(TaskEvent event) {
        if (event.type == Const.EventType.changeSceneProgress.getValue()) {
            int key = ((Integer) event.params[0]).intValue();
            Object value = event.params;
            if (value == null) {
                this.progress.remove(Integer.valueOf(key));
            } else {
                this.progress.put(Integer.valueOf(key), value);
            }
        }
    }


    public List<Object[]> toJson4BattleServer() {
        List<Object[]> data = new ArrayList();
        for (Iterator<Integer> iterator = this.progress.keySet().iterator(); iterator.hasNext(); ) {
            int key = ((Integer) iterator.next()).intValue();
            Object value = this.progress.get(Integer.valueOf(key));
            data.add(new Object[]{Integer.valueOf(key), value});
        }

        return data;
    }
}


