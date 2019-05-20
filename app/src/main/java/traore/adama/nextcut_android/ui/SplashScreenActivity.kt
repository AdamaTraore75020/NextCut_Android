package traore.adama.nextcut_android.ui

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.Animation
import traore.adama.nextcut_android.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoTitleBar_FullScreen);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animationView.setAnimation("loading_splashscreen.json")
        animationView.playAnimation()

        animationView.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationCancel(p0: Animator?) {
                Log.e("Animation:","cancel")
            }

            override fun onAnimationRepeat(p0: Animator?) {
                Log.e("Animation:","repeat")
            }

            override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                super.onAnimationEnd(animation, isReverse)
                Log.e("Animation:","end - isReverse : "+isReverse)
            }

            override fun onAnimationEnd(p0: Animator?) {
                Log.e("Animation:","end")
                MainActivity.launch(this@SplashScreenActivity)
            }

            override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                super.onAnimationStart(animation, isReverse)
                Log.e("Animation:","start")
            }

            override fun onAnimationStart(p0: Animator?) {
                Log.e("Animation:","start2") }
        })

    }

}
