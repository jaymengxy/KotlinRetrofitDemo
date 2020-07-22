package com.mxy.krd

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ProgressBarDrawable
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.mxy.krd.model.AnswerResponse
import com.mxy.krd.viewmodel.CustomViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mCustomViewModel: CustomViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[CustomViewModel::class.java]
    }

    private val resultObserver = Observer<AnswerResponse> { t -> refreshResult(t) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCustomViewModel.answerLiveData.observe(this, resultObserver)
        sdv_image.hierarchy = GenericDraweeHierarchyBuilder(resources).apply {
            fadeDuration = 300
            progressBarImage = ProgressBarDrawable()
            actualImageScaleType = ScalingUtils.ScaleType.CENTER_INSIDE
        }.build()

    }

    fun getAnswer(view: View) {
        mCustomViewModel.getDataFromServer()
    }

    private fun refreshResult(result: AnswerResponse?) {
        result?.let {
            sdv_image.controller = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(it.image))
                    .setAutoPlayAnimations(true)
                    .build()
            tv_text.text = it.answer.toUpperCase(Locale.getDefault())
        }
    }
}
