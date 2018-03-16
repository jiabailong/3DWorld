package com.mygdx.game;

import android.os.Handler;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.LoadingProgress;
import com.mygdx.game.widget.NewTecure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class LoadModel implements ApplicationListener {

    public PerspectiveCamera cam;
    public CameraInputController camController;
    public ModelBatch modelBatch;
    public AssetManager assets;
    public Array<ModelInstance> instances = new Array<ModelInstance>();
    public Environment environment;
    public boolean loading;
    public ModelInstance space;
    public ModelInstance ship;
    LoadingProgress progressDialog;
    Model model;
    @Override
    public void create() {
        modelBatch = new ModelBatch();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(1f, 1f, 2f);
        cam.lookAt(0, 0, 0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);


        ObjLoader loader = new ObjLoader();
        String rootpath=Gdx.files.getExternalStoragePath();
        TextureProvider.FileTextureProvider textureProvider=new TextureProvider.FileTextureProvider();
        NewTecure newTecure=new NewTecure();
        //        TextureProvider textureProvider=Gdx.files.external("/TAL16OBJ/ship.obj");
//         model = loader.loadModel(Gdx.files.absolute(Gdx.files.getExternalStoragePath()+"/TAL16OBJ/ship.obj"),textureProvider);
        model = loader.loadModel(Gdx.files.external("TAL16OBJ/ship.obj"),newTecure);
//            Texture texture=new Texture(Gdx.files.external("TAL16OBJ/ship.png"));
        // assets.load("skydome.g3db", Model.class);
        loading = true;
    }


    @Override
    public void render() {
        if (loading )
            doneLoading();
        camController.update();


        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(cam);
        modelBatch.render(instances, environment);
//        if (space != null)
//            modelBatch.render(space);
        modelBatch.end();
    }

    private void doneLoading() {
        ship  = new ModelInstance(model);
        instances.add(ship);
        //  space = new ModelInstance(assets.get("skydome.g3db", Model.class));
        loading = false;
        if(doneLoad!=null){
            doneLoad.doneLoad();
        }
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        instances.clear();
//        assets.dispose();
    }

    public void resume() {
    }

    public void resize(int width, int height) {
    }

    public void pause() {
        modelBatch.dispose();
        instances.clear();
//        assets.dispose();
    }
    DoneLoad doneLoad;
    public  void setDoneLoad(DoneLoad doneLoad){
        this.doneLoad=doneLoad;
    }
    public interface DoneLoad{
        public void doneLoad();
    }
}
