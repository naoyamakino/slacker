package com.naoya.slacker;

import com.naoya.slacker.daggermodules.DataModules;
import android.app.Application;
import dagger.ObjectGraph;

/**
 * Created by Naoya on 15-07-30.
 */
public class SlackerApplication extends Application {

    private ObjectGraph mObjectGraph;

    public final ObjectGraph getObjectGraph() {
        if (mObjectGraph == null) {
            mObjectGraph = ObjectGraph.create(new DataModules());
        }
        return mObjectGraph;
    }
}
