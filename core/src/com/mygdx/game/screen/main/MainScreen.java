package com.mygdx.game.screen.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MainClass;
import com.mygdx.game.enumerable.Assets;

public class MainScreen implements Screen {
    private Stage stage;
    private ImageButton logoImage;

    public MainScreen() {
        // Criamos um Stage nativo com as dimensões que você definiu na MainClass
        stage = new Stage(new StretchViewport(480, 800));
        Gdx.input.setInputProcessor(stage);

        setupUI();
    }

    private void setupUI() {
        // Criando o botão de imagem (BadLogic logo) usando Scene2D puro
        logoImage = new ImageButton(new TextureRegionDrawable(Assets.BAD_LOGIC.getValueAsTexture()));
        
        logoImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("MainScreen", "HELLO WORLD!"); // Substituindo o Toast que era da Kendao
            }
        });

        // Posicionamento centralizado
        logoImage.setPosition(
            (480 / 2f) - (logoImage.getWidth() / 2f),
            (800 / 2f) - (logoImage.getHeight() / 2f)
        );

        stage.addActor(logoImage);
        
        // NOTA: Os botões de texto (showAds, purchase) foram removidos temporariamente
        // porque o libGDX nativo exige um arquivo .json de "Skin" (fontes e estilos) 
        // que ainda não configuramos no novo projeto.
    }

    @Override
    public void render(float delta) {
        // Limpa a tela
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        stage.act(delta);
        stage.draw();
    }

    public void handleInput() {
        // Mantendo sua lógica de movimentação original
        float speed = 10f;
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) logoImage.moveBy(0, speed);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) logoImage.moveBy(0, -speed);
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) logoImage.moveBy(-speed, 0);
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) logoImage.moveBy(speed, 0);
    }

    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() { stage.dispose(); }
}
