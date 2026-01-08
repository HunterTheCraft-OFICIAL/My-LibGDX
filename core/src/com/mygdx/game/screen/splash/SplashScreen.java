package com.mygdx.game.screen.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MainClass;
import com.mygdx.game.enumerable.Assets;
import com.mygdx.game.screen.main.MainScreen;

public class SplashScreen implements Screen {
    private Stage stage;
    private boolean assetsLoaded = false;

    public SplashScreen() {
        // Criamos o Stage manualmente (substituindo o HudStage da Kendao)
        stage = new Stage(new StretchViewport(480, 800));
        
        // No libGDX puro, precisamos dizer ao AssetManager o que carregar
        loadAssetsQueue();

        // Criamos uma lógica de espera simples
        stage.addAction(
            Actions.sequence(
                Actions.delay(1f), // Tempo para mostrar a splash
                Actions.run(() -> {
                    assetsLoaded = true;
                })
            )
        );
    }

    private void loadAssetsQueue() {
        // Aqui você enfileira o que o AssetManager deve carregar
        // Exemplo: MainClass.getInstance().assets.load("badlogic.jpg", Texture.class);
        // Para facilitar, podemos percorrer o seu Enum de Assets se ele tiver um método de path:
        for (Assets asset : Assets.values()) {
            MainClass.getInstance().assets.load(asset.getPath(), com.badlogic.gdx.graphics.Texture.class);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        // O AssetManager oficial precisa deste comando para realmente carregar os arquivos
        // update() retorna true quando termina de carregar tudo
        if (MainClass.getInstance().assets.update() && assetsLoaded) {
            MainClass.getInstance().setScreen(new MainScreen());
        }
    }

    @Override public void show() {}
    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}
