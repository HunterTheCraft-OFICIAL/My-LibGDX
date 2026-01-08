package com.mygdx.game.enumerable;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainClass;

public enum Assets {
    // Adicione seus outros assets aqui seguindo o mesmo padrão
    BAD_LOGIC("badlogic.jpg");

    private final String path;

    Assets(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Texture getValueAsTexture() {
        // Busca o AssetManager que criamos na MainClass
        return MainClass.getInstance().assets.get(this.path, Texture.class);
    }

    public Sound getValueAsSound() {
        return MainClass.getInstance().assets.get(this.path, Sound.class);
    }

    public Music getValueAsMusic() {
        return MainClass.getInstance().assets.get(this.path, Music.class);
    }
}
