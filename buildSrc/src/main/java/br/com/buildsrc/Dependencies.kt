object Version {

    const val kotlin = "1.4.21"
    const val gradle = "4.1.1"
    const val appCompat = "1.2.0"
    const val coreKtx = "1.3.2"
    const val constraintLayout = "2.0.4"
    const val swiperefresh = "1.1.0"
    const val material = "1.2.1"
    const val interceptor = "4.8.1"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.2.0"
    const val koin = "2.1.5"
    const val picasso = "2.71828"
    const val sharedPreference = "1.1.1"
    const val navigation = "2.3.2"

    //test
    const val jUnit = "4.13.1"
    const val jUnitExt = "1.1.2"
    const val espresso = "3.3.0"
}

object Libs {

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
    const val sharedPreference = "androidx.preference:preference-ktx:${Version.sharedPreference}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Version.interceptor}"
    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swiperefresh}"
    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${Version.lifecycle}"
    const val coreKtx =  "androidx.core:core-ktx:${Version.coreKtx}"
    const val material = "com.google.android.material:material:${Version.material}"

    //Layout
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    //Networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

    //Koin
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"
    const val koinScope  = "org.koin:koin-androidx-scope:${Version.koin}"
    const val koin  = "org.koin:koin-android:${Version.koin}"
}

object LibsTest{
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Version.espresso}"
    const val jUnitExt = "androidx.test.ext:junit:${Version.jUnitExt}"
}