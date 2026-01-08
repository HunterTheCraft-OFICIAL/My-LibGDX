package com.mygdx.game;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
// Alteração 1: Importar a classe correta do seu projeto Core
import com.mygdx.game.MainClass; 

/** Launches the Android application. */
public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
        configuration.useImmersiveMode = true; 
        
        // Alteração 2: Trocar 'new Main()' por 'new MainClass()'
        initialize(new MainClass(), configuration);
    }
}
