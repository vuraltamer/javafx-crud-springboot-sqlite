package com.example.jfxtest.config;

import com.example.jfxtest.JfxTestApplication;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JavaFxConfiguration extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                applicationContext -> {
                applicationContext.registerBean(Application.class, () -> JavaFxConfiguration.this);
                applicationContext.registerBean(Parameters.class, () -> getParameters());
                applicationContext.registerBean(HostServices.class, () -> getHostServices());
                applicationContext.registerBean(Mapper.class, () -> new DozerBeanMapper());
            };

        this.context = new SpringApplicationBuilder()
                .sources(JfxTestApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() throws Exception {
        this.context.close();
        Platform.exit();
    }

    public class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return Stage.class.cast(getSource());
        }
    }
}
