import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.fetch.NetworkFetcher
import com.techieroid.common.Context
import com.techieroid.di.appModule
import com.techieroid.navigation.AppNavigation
import com.techieroid.ui.MainNav
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import org.koin.compose.KoinApplication
import presentation.theme.AppTheme


@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun App(context: Context){

    KoinApplication(application = {
        modules(appModule(context))
    }) {
        PreComposeApp {

            setSingletonImageLoaderFactory { context ->
                ImageLoader.Builder(context)
                    .components {
                        add(NetworkFetcher.Factory())
                    }
                    .build()
            }

            AppTheme {
                val navigator = rememberNavigator()
                Box(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navigator = navigator,
                        initialRoute = AppNavigation.Main.route,
                    ) {
                        scene(route = AppNavigation.Main.route) {
                            MainNav()

                        }
                    }

                }
            }
        }
    }
}