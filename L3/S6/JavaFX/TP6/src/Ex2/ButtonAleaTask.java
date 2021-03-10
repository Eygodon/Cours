package Ex2;


import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Button;

import java.util.Random;


public class ButtonAleaTask extends Button {
    //private AleaCoin aleaCoin;
    public ButtonAleaTask()
    {
        super("Tirer 10000000 lancer");
        //this.aleaCoin = new AleaCoin(100000000);

    }

    // Je déclare la tache dont la méthode call ne retourne rien
    private Service<Integer> coinTask = new Service()
    {
        // la méthode call qui contient le calcul.
        //updateMessage("Je calcule");
        //updateMessage(aleaCoin.getHeads() + " heads | " + aleaCoin.getTails() +" tails");
        @Override
        // la méthode createTask chargée de créer la tache
        protected Task<Integer> createTask()
        {
            return new Task()
            {
                @Override
                protected Integer call() throws Exception
                {
                    //aleaCoin.startLaunch();
                    //return aleaCoin.getHeads();
                    if (!this.isCancelled())
                    {
                        int res = 0;
                        Random rn = new Random();
                        updateMessage("0 heads");
                        int iterations = 100000000;
                        for (int i = 0; i < iterations; i++)
                        {
                            if (rn.nextBoolean())
                            {
                                res++;
                            }
                            if (i % 10000 == 0){
                                updateMessage(res+ " heads");
                                this.updateProgress(i, iterations);
                            }
                        }
                        return res;
                    }
                    else
                    {
                        return 0;
                    }
                }
            };
        }
    };

    public Service<Integer> getService()
    {
        return this.coinTask;
    }

    public void go()
    {
        this.setDisable(true);
        //this.textProperty().bind(coinTask.messageProperty());
        //coinTask.stateProperty().addListener(new ChangeListener<Worker.State>()
		/*{
			@Override
			public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State state, Worker.State t1)
			{
				switch(t1)
				{
					case SUCCEEDED: tmp.setDisable(false);
					case CANCELLED: // TODO
					case FAILED:  // TODO
				}
			}
		});*/
        coinTask.setOnSucceeded((e) -> {
            this.setDisable(false);
            this.textProperty().unbind();
            this.setText(coinTask.getValue() + " heads");
            coinTask.reset();
        });

        coinTask.setOnScheduled((e) ->{
            this.textProperty().bind(coinTask.messageProperty());
        });

        coinTask.setOnRunning((e) -> {
            // wow nothing much
        });

        coinTask.setOnCancelled((e) ->
        {
            this.setDisable(false);
            this.textProperty().unbind();
            this.setText("Operation Cancelled");
            coinTask.reset();
        });

        coinTask.start();
    }

    public void cancel()
    {
        this.coinTask.cancel();
    }
}
