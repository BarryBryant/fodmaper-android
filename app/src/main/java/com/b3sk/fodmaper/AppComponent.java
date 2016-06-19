package com.b3sk.fodmaper;

import com.b3sk.fodmaper.fragments.FodmapFragment;
import com.b3sk.fodmaper.fragments.FodmapFriendlyFragment;
import com.b3sk.fodmaper.fragments.ModerateFodmapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Joopkins on 6/19/16.
 */
@Singleton
@Component(modules={ AppModule.class })
public interface AppComponent {
    void inject(FodmapFragment target);
    void inject(ModerateFodmapFragment target);
    void inject(FodmapFriendlyFragment target);
}
