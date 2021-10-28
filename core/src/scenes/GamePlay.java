package scenes;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.yalcinsedat.jackthegiant.GameMain;

import helpers.GameInfo;

public class GamePlay  implements Screen {
    private Sprite[] bgs;
    private GameMain game;
    private OrthographicCamera mainCamera;
    private Viewport gameViewPort;
    private float lastPositionY;

    public GamePlay(GameMain game){
        this.game=game;
        mainCamera =new OrthographicCamera(GameInfo.WIDTH,GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH/2,GameInfo.HEIGHT/2,0);
        gameViewPort = new StretchViewport(GameInfo.WIDTH,GameInfo.HEIGHT,mainCamera);

       createBackgrounds();
    }

    void checkBackgroundsOutBounds(){
        for (int i=0; i<bgs.length;i++){
            if((bgs[i].getY()-bgs[i].getHeight()/2f - 5 > mainCamera.position.y)) {
                float newPosition=bgs[i].getHeight() + lastPositionY;
                bgs[i].setPosition(0,-newPosition);
                lastPositionY=Math.abs(newPosition);

            }
        }
    }
    void  update(float dt){
        moveCamera();
        checkBackgroundsOutBounds();
    }

    private void moveCamera() {
        mainCamera.position.y-=4;

    }

    void createBackgrounds(){
        bgs=new Sprite[3];
        for (int i=0;i<bgs.length;i++){
            bgs[i]=new Sprite(new Texture("Backgrounds/Game BG.png"));
            bgs[i].setPosition(0,-(i*bgs[i].getHeight()));
            lastPositionY=Math.abs(bgs[i].getY());

        }
    }

    void drawBackgrounds(){

        for (int i=0;i<bgs.length;i++){
            game.getBatch().draw(bgs[i],bgs[i].getX(),bgs[i].getY());
            //game.getBatch().draw(bgs[i],0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());



        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update(delta);

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        drawBackgrounds();
        game.getBatch().end();

        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();

    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}//GamePlay
