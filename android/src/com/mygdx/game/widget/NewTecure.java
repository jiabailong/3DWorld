package com.mygdx.game.widget;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;

/**
 * Created by jbl on 18-3-16.
 */

public class NewTecure extends TextureProvider.FileTextureProvider {
    private Texture.TextureFilter minFilter, magFilter;
    private Texture.TextureWrap uWrap, vWrap;
    private boolean useMipMaps;

    public NewTecure () {
        minFilter = magFilter = Texture.TextureFilter.Linear;
        uWrap = vWrap = Texture.TextureWrap.Repeat;
        useMipMaps = false;
    }

    public NewTecure (Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, Texture.TextureWrap uWrap,
                                Texture.TextureWrap vWrap, boolean useMipMaps) {
        this.minFilter = minFilter;
        this.magFilter = magFilter;
        this.uWrap = uWrap;
        this.vWrap = vWrap;
        this.useMipMaps = useMipMaps;
    }

    @Override
    public Texture load (String fileName) {
        Texture result = new Texture(Gdx.files.absolute(Gdx.files.getExternalStoragePath()+fileName), useMipMaps);
        result.setFilter(minFilter, magFilter);
        result.setWrap(uWrap, vWrap);
        return result;
    }
}
