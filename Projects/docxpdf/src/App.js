import React from 'react';
import './App.css';
import Drawer from './components/Drawer/Drawer';
import {
  Grid, Paper
} from '@material-ui/core';





function App() {
  return (
    <React.Fragment>
    <div className="App">
       
        {/* <h1>DOCX TO PDF CONVERTER</h1> */}
        {/* <AppBar></AppBar> */}
          {/* <Drawer > */}
                <Grid container sm={12}>
                  <Grid item sm={6}>
                       <Paper style={{padding: 20}} >
                        Left Pane
                    
                  </Paper>


                  </Grid>

                  <Grid item sm={6}>
                  <Paper style={{padding: 20}}>
                        Right Pane
                    
                  </Paper>
                        


                  </Grid>

                </Grid>



          {/* </Drawer> */}
       
    </div>
    </React.Fragment>
  );
}

export default App;
