package com.qindal.brakecoolingschedule;

//
// Created by Pablo on 17/08/2017.
//

import android.util.Log;

public class BrakeEnergy {

    // Matrix defining brake energy data
    //[Weight][OAT][Speed][Temperature]
    double[][][][] brakeEnergy;

    double[][] adjustedBrakeEnergyNoReverse;

    double[][] adjustedBrakeEnergySecondDentent;

    double[][] coolingTimeSteel;

    BrakeEnergy() {

        brakeEnergy = new double[5][7][6][3];
        adjustedBrakeEnergyNoReverse = new double[5][9];
        adjustedBrakeEnergySecondDentent = new double[5][9];
        coolingTimeSteel = new double[2][6];

        // 80tn 0º 80kt
        brakeEnergy[0][0][0][0] = 15.1;
        brakeEnergy[0][0][0][1] = 17.0;
        brakeEnergy[0][0][0][2] = 19.3;
        // 80tn 0º 100kt
        brakeEnergy[0][0][1][0] = 22.4;
        brakeEnergy[0][0][1][1] = 25.3;
        brakeEnergy[0][0][1][2] = 28.9;
        // 80tn 0º 120kt
        brakeEnergy[0][0][2][0] = 30.9;
        brakeEnergy[0][0][2][1] = 35.0;
        brakeEnergy[0][0][2][2] = 40.2;
        // 80tn 0º 140kt
        brakeEnergy[0][0][3][0] = 40.4;
        brakeEnergy[0][0][3][1] = 45.9;
        brakeEnergy[0][0][3][2] = 53.0;
        // 80tn 0º 160kt
        brakeEnergy[0][0][4][0] = 50.8;
        brakeEnergy[0][0][4][1] = 57.9;
        brakeEnergy[0][0][4][2] = 67.3;
        // 80tn 0º 180kt
        brakeEnergy[0][0][5][0] = 60.8;
        brakeEnergy[0][0][5][1] = 69.6;
        brakeEnergy[0][0][5][2] = 81.2;

        // 80tn 10º 80kt
        brakeEnergy[0][1][0][0] = 15.6;
        brakeEnergy[0][1][0][1] = 17.6;
        brakeEnergy[0][1][0][2] = 20.0;
        // 80tn 10º 100kt
        brakeEnergy[0][1][1][0] = 23.1;
        brakeEnergy[0][1][1][1] = 26.1;
        brakeEnergy[0][1][1][2] = 29.8;
        // 80tn 10º 120kt
        brakeEnergy[0][1][2][0] = 31.9;
        brakeEnergy[0][1][2][1] = 36.2;
        brakeEnergy[0][1][2][2] = 41.5;
        // 80tn 10º 140kt
        brakeEnergy[0][1][3][0] = 41.8;
        brakeEnergy[0][1][3][1] = 47.5;
        brakeEnergy[0][1][3][2] = 54.8;
        // 80tn 10º 160kt
        brakeEnergy[0][1][4][0] = 52.5;
        brakeEnergy[0][1][4][1] = 59.9;
        brakeEnergy[0][1][4][2] = 69.5;
        // 80tn 10º 180kt
        brakeEnergy[0][1][5][0] = 62.8;
        brakeEnergy[0][1][5][1] = 71.9;
        brakeEnergy[0][1][5][2] = 83.9;

        // 80tn 15º 80kt
        brakeEnergy[0][2][0][0] = 15.8;
        brakeEnergy[0][2][0][1] = 17.8;
        brakeEnergy[0][2][0][2] = 20.2;
        // 80tn 15º 100kt
        brakeEnergy[0][2][1][0] = 23.5;
        brakeEnergy[0][2][1][1] = 26.5;
        brakeEnergy[0][2][1][2] = 30.3;
        // 80tn 15º 120kt
        brakeEnergy[0][2][2][0] = 32.4;
        brakeEnergy[0][2][2][1] = 36.7;
        brakeEnergy[0][2][2][2] = 42.1;
        // 80tn 15º 140kt
        brakeEnergy[0][2][3][0] = 42.4;
        brakeEnergy[0][2][3][1] = 48.2;
        brakeEnergy[0][2][3][2] = 55.6;
        // 80tn 15º 160kt
        brakeEnergy[0][2][4][0] = 53.3;
        brakeEnergy[0][2][4][1] = 60.7;
        brakeEnergy[0][2][4][2] = 70.5;
        // 80tn 15º 180kt
        brakeEnergy[0][2][5][0] = 63.7;
        brakeEnergy[0][2][5][1] = 72.9;
        brakeEnergy[0][2][5][2] = 85.1;

        // 80tn 20º 80kt
        brakeEnergy[0][3][0][0] = 16.0;
        brakeEnergy[0][3][0][1] = 18.1;
        brakeEnergy[0][3][0][2] = 20.5;
        // 80tn 20º 100kt
        brakeEnergy[0][3][1][0] = 23.8;
        brakeEnergy[0][3][1][1] = 26.9;
        brakeEnergy[0][3][1][2] = 30.7;
        // 80tn 20º 120kt
        brakeEnergy[0][3][2][0] = 32.8;
        brakeEnergy[0][3][2][1] = 37.2;
        brakeEnergy[0][3][2][2] = 42.7;
        // 80tn 20º 140kt
        brakeEnergy[0][3][3][0] = 42.9;
        brakeEnergy[0][3][3][1] = 48.8;
        brakeEnergy[0][3][3][2] = 56.3;
        // 80tn 20º 160kt
        brakeEnergy[0][3][4][0] = 54.0;
        brakeEnergy[0][3][4][1] = 61.5;
        brakeEnergy[0][3][4][2] = 71.4;
        // 80tn 20º 180kt
        brakeEnergy[0][3][5][0] = 64.6;
        brakeEnergy[0][3][5][1] = 73.9;
        brakeEnergy[0][3][5][2] = 86.2;

        // 80tn 30º 80kt
        brakeEnergy[0][4][0][0] = 16.4;
        brakeEnergy[0][4][0][1] = 18.5;
        brakeEnergy[0][4][0][2] = 21.1;
        // 80tn 30º 100kt
        brakeEnergy[0][4][1][0] = 24.4;
        brakeEnergy[0][4][1][1] = 27.6;
        brakeEnergy[0][4][1][2] = 31.5;
        // 80tn 30º 120kt
        brakeEnergy[0][4][2][0] = 33.7;
        brakeEnergy[0][4][2][1] = 38.2;
        brakeEnergy[0][4][2][2] = 43.8;
        // 80tn 30º 140kt
        brakeEnergy[0][4][3][0] = 44.0;
        brakeEnergy[0][4][3][1] = 50.0;
        brakeEnergy[0][4][3][2] = 57.7;
        // 80tn 30º 160kt
        brakeEnergy[0][4][4][0] = 55.3;
        brakeEnergy[0][4][4][1] = 63.1;
        brakeEnergy[0][4][4][2] = 73.2;
        // 80tn 30º 180kt
        brakeEnergy[0][4][5][0] = 66.2;
        brakeEnergy[0][4][5][1] = 75.7;
        brakeEnergy[0][4][5][2] = 88.4;

        // 80tn 40º 80kt
        brakeEnergy[0][5][0][0] = 16.6;
        brakeEnergy[0][5][0][1] = 18.7;
        brakeEnergy[0][5][0][2] = 21.3;
        // 80tn 40º 100kt
        brakeEnergy[0][5][1][0] = 24.7;
        brakeEnergy[0][5][1][1] = 27.9;
        brakeEnergy[0][5][1][2] = 31.9;
        // 80tn 40º 120kt
        brakeEnergy[0][5][2][0] = 34.1;
        brakeEnergy[0][5][2][1] = 38.7;
        brakeEnergy[0][5][2][2] = 44.4;
        // 80tn 40º 140kt
        brakeEnergy[0][5][3][0] = 44.7;
        brakeEnergy[0][5][3][1] = 50.9;
        brakeEnergy[0][5][3][2] = 58.8;
        // 80tn 40º 160kt
        brakeEnergy[0][5][4][0] = 56.3;
        brakeEnergy[0][5][4][1] = 64.3;
        brakeEnergy[0][5][4][2] = 74.8;
        // 80tn 40º 180kt
        brakeEnergy[0][5][5][0] = 67.5;
        brakeEnergy[0][5][5][1] = 77.4;
        brakeEnergy[0][5][5][2] = 90.5;

        // 80tn 50º 80kt
        brakeEnergy[0][6][0][0] = 16.6;
        brakeEnergy[0][6][0][1] = 18.7;
        brakeEnergy[0][6][0][2] = 21.3;
        // 80tn 50º 100kt
        brakeEnergy[0][6][1][0] = 24.8;
        brakeEnergy[0][6][1][1] = 28.0;
        brakeEnergy[0][6][1][2] = 32.1;
        // 80tn 50º 120kt
        brakeEnergy[0][6][2][0] = 34.3;
        brakeEnergy[0][6][2][1] = 39.0;
        brakeEnergy[0][6][2][2] = 44.9;
        // 80tn 50º 140kt
        brakeEnergy[0][6][3][0] = 45.2;
        brakeEnergy[0][6][3][1] = 51.5;
        brakeEnergy[0][6][3][2] = 59.7;
        // 80tn 50º 160kt
        brakeEnergy[0][6][4][0] = 57.1;
        brakeEnergy[0][6][4][1] = 65.4;
        brakeEnergy[0][6][4][2] = 76.3;
        // 80tn 50º 180kt
        brakeEnergy[0][6][5][0] = 68.7;
        brakeEnergy[0][6][5][1] = 79.0;
        brakeEnergy[0][6][5][2] = 92.9;


        // 70tn 0º 80kt
        brakeEnergy[1][0][0][0] = 13.7;
        brakeEnergy[1][0][0][1] = 15.4;
        brakeEnergy[1][0][0][2] = 17.5;
        // 70tn 0º 100kt
        brakeEnergy[1][0][1][0] = 20.2;
        brakeEnergy[1][0][1][1] = 22.8;
        brakeEnergy[1][0][1][2] = 26.0;
        // 70tn 0º 120kt
        brakeEnergy[1][0][2][0] = 27.7;
        brakeEnergy[1][0][2][1] = 31.3;
        brakeEnergy[1][0][2][2] = 35.9;
        // 70tn 0º 140kt
        brakeEnergy[1][0][3][0] = 36.1;
        brakeEnergy[1][0][3][1] = 41.0;
        brakeEnergy[1][0][3][2] = 47.2;
        // 70tn 0º 160kt
        brakeEnergy[1][0][4][0] = 45.3;
        brakeEnergy[1][0][4][1] = 51.6;
        brakeEnergy[1][0][4][2] = 59.7;
        // 70tn 0º 180kt
        brakeEnergy[1][0][5][0] = 54.9;
        brakeEnergy[1][0][5][1] = 62.7;
        brakeEnergy[1][0][5][2] = 72.9;

        // 70tn 10º 80kt
        brakeEnergy[1][1][0][0] = 14.2;
        brakeEnergy[1][1][0][1] = 15.9;
        brakeEnergy[1][1][0][2] = 18.1;
        // 70tn 10º 100kt
        brakeEnergy[1][1][1][0] = 20.8;
        brakeEnergy[1][1][1][1] = 23.5;
        brakeEnergy[1][1][1][2] = 26.8;
        // 70tn 10º 120kt
        brakeEnergy[1][1][2][0] = 28.6;
        brakeEnergy[1][1][2][1] = 32.4;
        brakeEnergy[1][1][2][2] = 37.1;
        // 70tn 10º 140kt
        brakeEnergy[1][1][3][0] = 37.3;
        brakeEnergy[1][1][3][1] = 42.3;
        brakeEnergy[1][1][3][2] = 48.7;
        // 70tn 10º 160kt
        brakeEnergy[1][1][4][0] = 46.8;
        brakeEnergy[1][1][4][1] = 53.3;
        brakeEnergy[1][1][4][2] = 61.6;
        // 70tn 10º 180kt
        brakeEnergy[1][1][5][0] = 56.7;
        brakeEnergy[1][1][5][1] = 64.8;
        brakeEnergy[1][1][5][2] = 75.4;

        // 70tn 15º 80kt
        brakeEnergy[1][2][0][0] = 14.4;
        brakeEnergy[1][2][0][1] = 16.2;
        brakeEnergy[1][2][0][2] = 18.4;
        // 70tn 15º 100kt
        brakeEnergy[1][2][1][0] = 21.1;
        brakeEnergy[1][2][1][1] = 23.9;
        brakeEnergy[1][2][1][2] = 27.2;
        // 70tn 15º 120kt
        brakeEnergy[1][2][2][0] = 29.0;
        brakeEnergy[1][2][2][1] = 32.8;
        brakeEnergy[1][2][2][2] = 37.6;
        // 70tn 15º 140kt
        brakeEnergy[1][2][3][0] = 37.8;
        brakeEnergy[1][2][3][1] = 43.0;
        brakeEnergy[1][2][3][2] = 49.4;
        // 70tn 15º 160kt
        brakeEnergy[1][2][4][0] = 47.5;
        brakeEnergy[1][2][4][1] = 54.0;
        brakeEnergy[1][2][4][2] = 62.5;
        // 70tn 15º 180kt
        brakeEnergy[1][2][5][0] = 57.5;
        brakeEnergy[1][2][5][1] = 65.7;
        brakeEnergy[1][2][5][2] = 76.4;

        // 70tn 20º 80kt
        brakeEnergy[1][3][0][0] = 14.6;
        brakeEnergy[1][3][0][1] = 16.4;
        brakeEnergy[1][3][0][2] = 18.6;
        // 70tn 20º 100kt
        brakeEnergy[1][3][1][0] = 21.4;
        brakeEnergy[1][3][1][1] = 24.2;
        brakeEnergy[1][3][1][2] = 27.6;
        // 70tn 20º 120kt
        brakeEnergy[1][3][2][0] = 29.4;
        brakeEnergy[1][3][2][1] = 33.3;
        brakeEnergy[1][3][2][2] = 38.1;
        // 70tn 20º 140kt
        brakeEnergy[1][3][3][0] = 38.4;
        brakeEnergy[1][3][3][1] = 43.5;
        brakeEnergy[1][3][3][2] = 50.1;
        // 70tn 20º 160kt
        brakeEnergy[1][3][4][0] = 48.1;
        brakeEnergy[1][3][4][1] = 54.8;
        brakeEnergy[1][3][4][2] = 63.4;
        // 70tn 20º 180kt
        brakeEnergy[1][3][5][0] = 58.3;
        brakeEnergy[1][3][5][1] = 66.5;
        brakeEnergy[1][3][5][2] = 77.4;

        // 70tn 30º 80kt
        brakeEnergy[1][4][0][0] = 14.9;
        brakeEnergy[1][4][0][1] = 16.8;
        brakeEnergy[1][4][0][2] = 19.1;
        // 70tn 30º 100kt
        brakeEnergy[1][4][1][0] = 22.0;
        brakeEnergy[1][4][1][1] = 24.8;
        brakeEnergy[1][4][1][2] = 28.3;
        // 70tn 30º 120kt
        brakeEnergy[1][4][2][0] = 30.2;
        brakeEnergy[1][4][2][1] = 34.1;
        brakeEnergy[1][4][2][2] = 39.1;
        // 70tn 30º 140kt
        brakeEnergy[1][4][3][0] = 39.3;
        brakeEnergy[1][4][3][1] = 44.6;
        brakeEnergy[1][4][3][2] = 51.4;
        // 70tn 30º 160kt
        brakeEnergy[1][4][4][0] = 49.3;
        brakeEnergy[1][4][4][1] = 56.1;
        brakeEnergy[1][4][4][2] = 64.9;
        // 70tn 30º 180kt
        brakeEnergy[1][4][5][0] = 59.8;
        brakeEnergy[1][4][5][1] = 68.2;
        brakeEnergy[1][4][5][2] = 79.4;

        // 70tn 40º 80kt
        brakeEnergy[1][5][0][0] = 15.1;
        brakeEnergy[1][5][0][1] = 17.0;
        brakeEnergy[1][5][0][2] = 19.3;
        // 70tn 40º 100kt
        brakeEnergy[1][5][1][0] = 22.2;
        brakeEnergy[1][5][1][1] = 25.1;
        brakeEnergy[1][5][1][2] = 28.6;
        // 70tn 40º 120kt
        brakeEnergy[1][5][2][0] = 30.5;
        brakeEnergy[1][5][2][1] = 34.6;
        brakeEnergy[1][5][2][2] = 39.6;
        // 70tn 40º 140kt
        brakeEnergy[1][5][3][0] = 39.9;
        brakeEnergy[1][5][3][1] = 45.3;
        brakeEnergy[1][5][3][2] = 52.2;
        // 70tn 40º 160kt
        brakeEnergy[1][5][4][0] = 50.1;
        brakeEnergy[1][5][4][1] = 57.1;
        brakeEnergy[1][5][4][2] = 66.2;
        // 70tn 40º 180kt
        brakeEnergy[1][5][5][0] = 60.9;
        brakeEnergy[1][5][5][1] = 69.6;
        brakeEnergy[1][5][5][2] = 81.2;

        // 70tn 50º 80kt
        brakeEnergy[1][6][0][0] = 15.1;
        brakeEnergy[1][6][0][1] = 17.0;
        brakeEnergy[1][6][0][2] = 19.3;
        // 70tn 50º 100kt
        brakeEnergy[1][6][1][0] = 22.3;
        brakeEnergy[1][6][1][1] = 25.2;
        brakeEnergy[1][6][1][2] = 28.8;
        // 70tn 50º 120kt
        brakeEnergy[1][6][2][0] = 30.7;
        brakeEnergy[1][6][2][1] = 34.8;
        brakeEnergy[1][6][2][2] = 40.0;
        // 70tn 50º 140kt
        brakeEnergy[1][6][3][0] = 40.2;
        brakeEnergy[1][6][3][1] = 45.8;
        brakeEnergy[1][6][3][2] = 52.9;
        // 70tn 50º 160kt
        brakeEnergy[1][6][4][0] = 50.7;
        brakeEnergy[1][6][4][1] = 58.0;
        brakeEnergy[1][6][4][2] = 67.4;
        // 70tn 50º 180kt
        brakeEnergy[1][6][5][0] = 61.8;
        brakeEnergy[1][6][5][1] = 70.9;
        brakeEnergy[1][6][5][2] = 83.0;


        // 60tn 0º 80kt
        brakeEnergy[2][0][0][0] = 12.3;
        brakeEnergy[2][0][0][1] = 13.9;
        brakeEnergy[2][0][0][2] = 15.7;
        // 60tn 0º 100kt
        brakeEnergy[2][0][1][0] = 18.0;
        brakeEnergy[2][0][1][1] = 20.3;
        brakeEnergy[2][0][1][2] = 23.1;
        // 60tn 0º 120kt
        brakeEnergy[2][0][2][0] = 24.4;
        brakeEnergy[2][0][2][1] = 27.6;
        brakeEnergy[2][0][2][2] = 31.6;
        // 60tn 0º 140kt
        brakeEnergy[2][0][3][0] = 31.7;
        brakeEnergy[2][0][3][1] = 35.9;
        brakeEnergy[2][0][3][2] = 41.2;
        // 60tn 0º 160kt
        brakeEnergy[2][0][4][0] = 39.6;
        brakeEnergy[2][0][4][1] = 45.0;
        brakeEnergy[2][0][4][2] = 51.8;
        // 60tn 0º 180kt
        brakeEnergy[2][0][5][0] = 48.1;
        brakeEnergy[2][0][5][1] = 54.8;
        brakeEnergy[2][0][5][2] = 63.5;

        // 60tn 10º 80kt
        brakeEnergy[2][1][0][0] = 12.7;
        brakeEnergy[2][1][0][1] = 14.3;
        brakeEnergy[2][1][0][2] = 16.3;
        // 60tn 10º 100kt
        brakeEnergy[2][1][1][0] = 18.5;
        brakeEnergy[2][1][1][1] = 20.9;
        brakeEnergy[2][1][1][2] = 23.8;
        // 60tn 10º 120kt
        brakeEnergy[2][1][2][0] = 25.2;
        brakeEnergy[2][1][2][1] = 28.5;
        brakeEnergy[2][1][2][2] = 32.6;
        // 60tn 10º 140kt
        brakeEnergy[2][1][3][0] = 32.7;
        brakeEnergy[2][1][3][1] = 37.1;
        brakeEnergy[2][1][3][2] = 42.6;
        // 60tn 10º 160kt
        brakeEnergy[2][1][4][0] = 40.9;
        brakeEnergy[2][1][4][1] = 46.5;
        brakeEnergy[2][1][4][2] = 53.6;
        // 60tn 10º 180kt
        brakeEnergy[2][1][5][0] = 49.7;
        brakeEnergy[2][1][5][1] = 56.6;
        brakeEnergy[2][1][5][2] = 65.6;

        // 60tn 15º 80kt
        brakeEnergy[2][2][0][0] = 12.9;
        brakeEnergy[2][2][0][1] = 14.6;
        brakeEnergy[2][2][0][2] = 16.5;
        // 60tn 15º 100kt
        brakeEnergy[2][2][1][0] = 18.8;
        brakeEnergy[2][2][1][1] = 21.2;
        brakeEnergy[2][2][1][2] = 24.2;
        // 60tn 15º 120kt
        brakeEnergy[2][2][2][0] = 25.6;
        brakeEnergy[2][2][2][1] = 29.0;
        brakeEnergy[2][2][2][2] = 33.1;
        // 60tn 15º 140kt
        brakeEnergy[2][2][3][0] = 33.2;
        brakeEnergy[2][2][3][1] = 37.6;
        brakeEnergy[2][2][3][2] = 43.2;
        // 60tn 15º 160kt
        brakeEnergy[2][2][4][0] = 41.5;
        brakeEnergy[2][2][4][1] = 47.1;
        brakeEnergy[2][2][4][2] = 54.4;
        // 60tn 15º 180kt
        brakeEnergy[2][2][5][0] = 50.4;
        brakeEnergy[2][2][5][1] = 57.4;
        brakeEnergy[2][2][5][2] = 66.5;

        // 60tn 20º 80kt
        brakeEnergy[2][3][0][0] = 13.1;
        brakeEnergy[2][3][0][1] = 14.8;
        brakeEnergy[2][3][0][2] = 16.7;
        // 60tn 20º 100kt
        brakeEnergy[2][3][1][0] = 19.1;
        brakeEnergy[2][3][1][1] = 21.5;
        brakeEnergy[2][3][1][2] = 24.5;
        // 60tn 20º 120kt
        brakeEnergy[2][3][2][0] = 26.0;
        brakeEnergy[2][3][2][1] = 29.4;
        brakeEnergy[2][3][2][2] = 33.5;
        // 60tn 20º 140kt
        brakeEnergy[2][3][3][0] = 33.6;
        brakeEnergy[2][3][3][1] = 38.1;
        brakeEnergy[2][3][3][2] = 43.8;
        // 60tn 20º 160kt
        brakeEnergy[2][3][4][0] = 42.0;
        brakeEnergy[2][3][4][1] = 47.8;
        brakeEnergy[2][3][4][2] = 55.1;
        // 60tn 20º 180kt
        brakeEnergy[2][3][5][0] = 51.1;
        brakeEnergy[2][3][5][1] = 58.2;
        brakeEnergy[2][3][5][2] = 67.4;

        // 60tn 30º 80kt
        brakeEnergy[2][4][0][0] = 13.4;
        brakeEnergy[2][4][0][1] = 15.1;
        brakeEnergy[2][4][0][2] = 17.2;
        // 60tn 30º 100kt
        brakeEnergy[2][4][1][0] = 19.6;
        brakeEnergy[2][4][1][1] = 22.1;
        brakeEnergy[2][4][1][2] = 25.1;
        // 60tn 30º 120kt
        brakeEnergy[2][4][2][0] = 26.6;
        brakeEnergy[2][4][2][1] = 30.1;
        brakeEnergy[2][4][2][2] = 34.4;
        // 60tn 30º 140kt
        brakeEnergy[2][4][3][0] = 34.5;
        brakeEnergy[2][4][3][1] = 39.1;
        brakeEnergy[2][4][3][2] = 44.9;
        // 60tn 30º 160kt
        brakeEnergy[2][4][4][0] = 43.1;
        brakeEnergy[2][4][4][1] = 49.0;
        brakeEnergy[2][4][4][2] = 56.5;
        // 60tn 30º 180kt
        brakeEnergy[2][4][5][0] = 52.3;
        brakeEnergy[2][4][5][1] = 59.6;
        brakeEnergy[2][4][5][2] = 69.1;

        // 60tn 40º 80kt
        brakeEnergy[2][5][0][0] = 13.6;
        brakeEnergy[2][5][0][1] = 15.3;
        brakeEnergy[2][5][0][2] = 17.3;
        // 60tn 40º 100kt
        brakeEnergy[2][5][1][0] = 19.8;
        brakeEnergy[2][5][1][1] = 22.3;
        brakeEnergy[2][5][1][2] = 25.4;
        // 60tn 40º 120kt
        brakeEnergy[2][5][2][0] = 26.9;
        brakeEnergy[2][5][2][1] = 30.5;
        brakeEnergy[2][5][2][2] = 34.9;
        // 60tn 40º 140kt
        brakeEnergy[2][5][3][0] = 35.0;
        brakeEnergy[2][5][3][1] = 39.7;
        brakeEnergy[2][5][3][2] = 45.6;
        // 60tn 40º 160kt
        brakeEnergy[2][5][4][0] = 43.8;
        brakeEnergy[2][5][4][1] = 49.8;
        brakeEnergy[2][5][4][2] = 57.5;
        // 60tn 40º 180kt
        brakeEnergy[2][5][5][0] = 53.2;
        brakeEnergy[2][5][5][1] = 60.7;
        brakeEnergy[2][5][5][2] = 70.5;

        // 60tn 50º 80kt
        brakeEnergy[2][6][0][0] = 13.5;
        brakeEnergy[2][6][0][1] = 15.3;
        brakeEnergy[2][6][0][2] = 17.3;
        // 60tn 50º 100kt
        brakeEnergy[2][6][1][0] = 19.8;
        brakeEnergy[2][6][1][1] = 22.4;
        brakeEnergy[2][6][1][2] = 25.5;
        // 60tn 50º 120kt
        brakeEnergy[2][6][2][0] = 27.0;
        brakeEnergy[2][6][2][1] = 30.6;
        brakeEnergy[2][6][2][2] = 35.1;
        // 60tn 50º 140kt
        brakeEnergy[2][6][3][0] = 35.2;
        brakeEnergy[2][6][3][1] = 40.0;
        brakeEnergy[2][6][3][2] = 46.0;
        // 60tn 50º 160kt
        brakeEnergy[2][6][4][0] = 44.2;
        brakeEnergy[2][6][4][1] = 50.4;
        brakeEnergy[2][6][4][2] = 58.3;
        // 60tn 50º 180kt
        brakeEnergy[2][6][5][0] = 53.9;
        brakeEnergy[2][6][5][1] = 61.7;
        brakeEnergy[2][6][5][2] = 71.9;


        // 50tn 0º 80kt
        brakeEnergy[3][0][0][0] = 11.0;
        brakeEnergy[3][0][0][1] = 12.3;
        brakeEnergy[3][0][0][2] = 14.0;
        // 50tn 0º 100kt
        brakeEnergy[3][0][1][0] = 15.7;
        brakeEnergy[3][0][1][1] = 17.7;
        brakeEnergy[3][0][1][2] = 20.2;
        // 50tn 0º 120kt
        brakeEnergy[3][0][2][0] = 21.2;
        brakeEnergy[3][0][2][1] = 23.9;
        brakeEnergy[3][0][2][2] = 27.3;
        // 50tn 0º 140kt
        brakeEnergy[3][0][3][0] = 27.2;
        brakeEnergy[3][0][3][1] = 30.8;
        brakeEnergy[3][0][3][2] = 35.3;
        // 50tn 0º 160kt
        brakeEnergy[3][0][4][0] = 33.8;
        brakeEnergy[3][0][4][1] = 38.3;
        brakeEnergy[3][0][4][2] = 44.1;
        // 50tn 0º 180kt
        brakeEnergy[3][0][5][0] = 40.9;
        brakeEnergy[3][0][5][1] = 46.4;
        brakeEnergy[3][0][5][2] = 53.6;

        // 50tn 10º 80kt
        brakeEnergy[3][1][0][0] = 11.3;
        brakeEnergy[3][1][0][1] = 12.7;
        brakeEnergy[3][1][0][2] = 14.4;
        // 50tn 10º 100kt
        brakeEnergy[3][1][1][0] = 16.3;
        brakeEnergy[3][1][1][1] = 18.3;
        brakeEnergy[3][1][1][2] = 20.8;
        // 50tn 10º 120kt
        brakeEnergy[3][1][2][0] = 21.9;
        brakeEnergy[3][1][2][1] = 24.7;
        brakeEnergy[3][1][2][2] = 28.2;
        // 50tn 10º 140kt
        brakeEnergy[3][1][3][0] = 28.1;
        brakeEnergy[3][1][3][1] = 31.8;
        brakeEnergy[3][1][3][2] = 36.5;
        // 50tn 10º 160kt
        brakeEnergy[3][1][4][0] = 34.9;
        brakeEnergy[3][1][4][1] = 39.6;
        brakeEnergy[3][1][4][2] = 45.5;
        // 50tn 10º 180kt
        brakeEnergy[3][1][5][0] = 42.2;
        brakeEnergy[3][1][5][1] = 48.0;
        brakeEnergy[3][1][5][2] = 55.4;

        // 50tn 15º 80kt
        brakeEnergy[3][2][0][0] = 11.5;
        brakeEnergy[3][2][0][1] = 12.9;
        brakeEnergy[3][2][0][2] = 14.7;
        // 50tn 15º 100kt
        brakeEnergy[3][2][1][0] = 16.5;
        brakeEnergy[3][2][1][1] = 18.6;
        brakeEnergy[3][2][1][2] = 21.1;
        // 50tn 15º 120kt
        brakeEnergy[3][2][2][0] = 22.2;
        brakeEnergy[3][2][2][1] = 25.1;
        brakeEnergy[3][2][2][2] = 28.6;
        // 50tn 15º 140kt
        brakeEnergy[3][2][3][0] = 28.6;
        brakeEnergy[3][2][3][1] = 32.3;
        brakeEnergy[3][2][3][2] = 37.0;
        // 50tn 15º 160kt
        brakeEnergy[3][2][4][0] = 35.4;
        brakeEnergy[3][2][4][1] = 40.2;
        brakeEnergy[3][2][4][2] = 46.2;
        // 50tn 15º 180kt
        brakeEnergy[3][2][5][0] = 42.8;
        brakeEnergy[3][2][5][1] = 48.7;
        brakeEnergy[3][2][5][2] = 56.2;

        // 50tn 20º 80kt
        brakeEnergy[3][3][0][0] = 11.6;
        brakeEnergy[3][3][0][1] = 13.1;
        brakeEnergy[3][3][0][2] = 14.9;
        // 50tn 20º 100kt
        brakeEnergy[3][3][1][0] = 16.7;
        brakeEnergy[3][3][1][1] = 18.9;
        brakeEnergy[3][3][1][2] = 21.4;
        // 50tn 20º 120kt
        brakeEnergy[3][3][2][0] = 22.5;
        brakeEnergy[3][3][2][1] = 25.4;
        brakeEnergy[3][3][2][2] = 29.0;
        // 50tn 20º 140kt
        brakeEnergy[3][3][3][0] = 28.9;
        brakeEnergy[3][3][3][1] = 32.8;
        brakeEnergy[3][3][3][2] = 37.5;
        // 50tn 20º 160kt
        brakeEnergy[3][3][4][0] = 35.9;
        brakeEnergy[3][3][4][1] = 40.7;
        brakeEnergy[3][3][4][2] = 46.8;
        // 50tn 20º 180kt
        brakeEnergy[3][3][5][0] = 43.4;
        brakeEnergy[3][3][5][1] = 49.3;
        brakeEnergy[3][3][5][2] = 56.9;

        // 50tn 30º 80kt
        brakeEnergy[3][4][0][0] = 11.9;
        brakeEnergy[3][4][0][1] = 13.4;
        brakeEnergy[3][4][0][2] = 15.2;
        // 50tn 30º 100kt
        brakeEnergy[3][4][1][0] = 17.2;
        brakeEnergy[3][4][1][1] = 19.3;
        brakeEnergy[3][4][1][2] = 22.0;
        // 50tn 30º 120kt
        brakeEnergy[3][4][2][0] = 23.1;
        brakeEnergy[3][4][2][1] = 26.1;
        brakeEnergy[3][4][2][2] = 29.7;
        // 50tn 30º 140kt
        brakeEnergy[3][4][3][0] = 29.7;
        brakeEnergy[3][4][3][1] = 33.6;
        brakeEnergy[3][4][3][2] = 38.4;
        // 50tn 30º 160kt
        brakeEnergy[3][4][4][0] = 36.8;
        brakeEnergy[3][4][4][1] = 41.8;
        brakeEnergy[3][4][4][2] = 48.0;
        // 50tn 30º 180kt
        brakeEnergy[3][4][5][0] = 44.5;
        brakeEnergy[3][4][5][1] = 50.6;
        brakeEnergy[3][4][5][2] = 58.4;

        // 50tn 40º 80kt
        brakeEnergy[3][5][0][0] = 12.1;
        brakeEnergy[3][5][0][1] = 13.6;
        brakeEnergy[3][5][0][2] = 15.4;
        // 50tn 40º 100kt
        brakeEnergy[3][5][1][0] = 17.3;
        brakeEnergy[3][5][1][1] = 19.5;
        brakeEnergy[3][5][1][2] = 22.2;
        // 50tn 40º 120kt
        brakeEnergy[3][5][2][0] = 23.4;
        brakeEnergy[3][5][2][1] = 26.4;
        brakeEnergy[3][5][2][2] = 30.1;
        // 50tn 40º 140kt
        brakeEnergy[3][5][3][0] = 30.1;
        brakeEnergy[3][5][3][1] = 34.0;
        brakeEnergy[3][5][3][2] = 39.0;
        // 50tn 40º 160kt
        brakeEnergy[3][5][4][0] = 37.4;
        brakeEnergy[3][5][4][1] = 42.4;
        brakeEnergy[3][5][4][2] = 48.8;
        // 50tn 40º 180kt
        brakeEnergy[3][5][5][0] = 45.2;
        brakeEnergy[3][5][5][1] = 51.4;
        brakeEnergy[3][5][5][2] = 59.4;

        // 50tn 50º 80kt
        brakeEnergy[3][6][0][0] = 12.0;
        brakeEnergy[3][6][0][1] = 13.6;
        brakeEnergy[3][6][0][2] = 15.4;
        // 50tn 50º 100kt
        brakeEnergy[3][6][1][0] = 17.3;
        brakeEnergy[3][6][1][1] = 19.6;
        brakeEnergy[3][6][1][2] = 22.3;
        // 50tn 50º 120kt
        brakeEnergy[3][6][2][0] = 23.4;
        brakeEnergy[3][6][2][1] = 26.5;
        brakeEnergy[3][6][2][2] = 30.3;
        // 50tn 50º 140kt
        brakeEnergy[3][6][3][0] = 30.2;
        brakeEnergy[3][6][3][1] = 34.2;
        brakeEnergy[3][6][3][2] = 39.3;
        // 50tn 50º 160kt
        brakeEnergy[3][6][4][0] = 37.6;
        brakeEnergy[3][6][4][1] = 42.8;
        brakeEnergy[3][6][4][2] = 49.3;
        // 50tn 50º 180kt
        brakeEnergy[3][6][5][0] = 45.7;
        brakeEnergy[3][6][5][1] = 52.1;
        brakeEnergy[3][6][5][2] = 60.3;


        // 40tn 0º 80kt
        brakeEnergy[4][0][0][0] = 9.6;
        brakeEnergy[4][0][0][1] = 10.8;
        brakeEnergy[4][0][0][2] = 12.3;
        // 40tn 0º 100kt
        brakeEnergy[4][0][1][0] = 13.5;
        brakeEnergy[4][0][1][1] = 15.2;
        brakeEnergy[4][0][1][2] = 17.3;
        // 40tn 0º 120kt
        brakeEnergy[4][0][2][0] = 17.9;
        brakeEnergy[4][0][2][1] = 20.2;
        brakeEnergy[4][0][2][2] = 23.0;
        // 40tn 0º 140kt
        brakeEnergy[4][0][3][0] = 22.8;
        brakeEnergy[4][0][3][1] = 25.8;
        brakeEnergy[4][0][3][2] = 29.4;
        // 40tn 0º 160kt
        brakeEnergy[4][0][4][0] = 28.1;
        brakeEnergy[4][0][4][1] = 31.8;
        brakeEnergy[4][0][4][2] = 36.4;
        // 40tn 0º 180kt
        brakeEnergy[4][0][5][0] = 33.7;
        brakeEnergy[4][0][5][1] = 38.2;
        brakeEnergy[4][0][5][2] = 43.9;

        // 40tn 10º 80kt
        brakeEnergy[4][1][0][0] = 10.0;
        brakeEnergy[4][1][0][1] = 11.2;
        brakeEnergy[4][1][0][2] = 12.7;
        // 40tn 10º 100kt
        brakeEnergy[4][1][1][0] = 14.0;
        brakeEnergy[4][1][1][1] = 15.8;
        brakeEnergy[4][1][1][2] = 17.9;
        // 40tn 10º 120kt
        brakeEnergy[4][1][2][0] = 18.5;
        brakeEnergy[4][1][2][1] = 20.9;
        brakeEnergy[4][1][2][2] = 23.8;
        // 40tn 10º 140kt
        brakeEnergy[4][1][3][0] = 23.6;
        brakeEnergy[4][1][3][1] = 26.6;
        brakeEnergy[4][1][3][2] = 30.4;
        // 40tn 10º 160kt
        brakeEnergy[4][1][4][0] = 29.0;
        brakeEnergy[4][1][4][1] = 32.8;
        brakeEnergy[4][1][4][2] = 37.6;
        // 40tn 10º 180kt
        brakeEnergy[4][1][5][0] = 34.8;
        brakeEnergy[4][1][5][1] = 39.5;
        brakeEnergy[4][1][5][2] = 45.4;

        // 40tn 15º 80kt
        brakeEnergy[4][2][0][0] = 10.1;
        brakeEnergy[4][2][0][1] = 11.4;
        brakeEnergy[4][2][0][2] = 12.9;
        // 40tn 15º 100kt
        brakeEnergy[4][2][1][0] = 14.2;
        brakeEnergy[4][2][1][1] = 16.0;
        brakeEnergy[4][2][1][2] = 18.1;
        // 40tn 15º 120kt
        brakeEnergy[4][2][2][0] = 18.8;
        brakeEnergy[4][2][2][1] = 21.2;
        brakeEnergy[4][2][2][2] = 24.1;
        // 40tn 15º 140kt
        brakeEnergy[4][2][3][0] = 23.9;
        brakeEnergy[4][2][3][1] = 27.0;
        brakeEnergy[4][2][3][2] = 30.8;
        // 40tn 15º 160kt
        brakeEnergy[4][2][4][0] = 29.4;
        brakeEnergy[4][2][4][1] = 33.3;
        brakeEnergy[4][2][4][2] = 38.2;
        // 40tn 15º 180kt
        brakeEnergy[4][2][5][0] = 35.3;
        brakeEnergy[4][2][5][1] = 40.0;
        brakeEnergy[4][2][5][2] = 46.0;

        // 40tn 20º 80kt
        brakeEnergy[4][3][0][0] = 10.2;
        brakeEnergy[4][3][0][1] = 11.5;
        brakeEnergy[4][3][0][2] = 13.1;
        // 40tn 20º 100kt
        brakeEnergy[4][3][1][0] = 14.4;
        brakeEnergy[4][3][1][1] = 16.2;
        brakeEnergy[4][3][1][2] = 18.4;
        // 40tn 20º 120kt
        brakeEnergy[4][3][2][0] = 19.1;
        brakeEnergy[4][3][2][1] = 21.5;
        brakeEnergy[4][3][2][2] = 24.5;
        // 40tn 20º 140kt
        brakeEnergy[4][3][3][0] = 24.2;
        brakeEnergy[4][3][3][1] = 27.4;
        brakeEnergy[4][3][3][2] = 31.3;
        // 40tn 20º 160kt
        brakeEnergy[4][3][4][0] = 29.8;
        brakeEnergy[4][3][4][1] = 33.8;
        brakeEnergy[4][3][4][2] = 38.7;
        // 40tn 20º 180kt
        brakeEnergy[4][3][5][0] = 35.8;
        brakeEnergy[4][3][5][1] = 40.6;
        brakeEnergy[4][3][5][2] = 46.6;

        // 40tn 30º 80kt
        brakeEnergy[4][4][0][0] = 10.5;
        brakeEnergy[4][4][0][1] = 11.8;
        brakeEnergy[4][4][0][2] = 13.4;
        // 40tn 30º 100kt
        brakeEnergy[4][4][1][0] = 14.8;
        brakeEnergy[4][4][1][1] = 16.6;
        brakeEnergy[4][4][1][2] = 18.9;
        // 40tn 30º 120kt
        brakeEnergy[4][4][2][0] = 19.6;
        brakeEnergy[4][4][2][1] = 22.1;
        brakeEnergy[4][4][2][2] = 25.1;
        // 40tn 30º 140kt
        brakeEnergy[4][4][3][0] = 24.9;
        brakeEnergy[4][4][3][1] = 28.1;
        brakeEnergy[4][4][3][2] = 32.1;
        // 40tn 30º 160kt
        brakeEnergy[4][4][4][0] = 30.6;
        brakeEnergy[4][4][4][1] = 34.6;
        brakeEnergy[4][4][4][2] = 39.7;
        // 40tn 30º 180kt
        brakeEnergy[4][4][5][0] = 36.7;
        brakeEnergy[4][4][5][1] = 41.6;
        brakeEnergy[4][4][5][2] = 47.8;

        // 40tn 40º 80kt
        brakeEnergy[4][5][0][0] = 10.6;
        brakeEnergy[4][5][0][1] = 11.9;
        brakeEnergy[4][5][0][2] = 13.5;
        // 40tn 40º 100kt
        brakeEnergy[4][5][1][0] = 14.9;
        brakeEnergy[4][5][1][1] = 16.8;
        brakeEnergy[4][5][1][2] = 19.1;
        // 40tn 40º 120kt
        brakeEnergy[4][5][2][0] = 19.8;
        brakeEnergy[4][5][2][1] = 22.3;
        brakeEnergy[4][5][2][2] = 25.4;
        // 40tn 40º 140kt
        brakeEnergy[4][5][3][0] = 25.2;
        brakeEnergy[4][5][3][1] = 28.4;
        brakeEnergy[4][5][3][2] = 32.5;
        // 40tn 40º 160kt
        brakeEnergy[4][5][4][0] = 31.0;
        brakeEnergy[4][5][4][1] = 35.1;
        brakeEnergy[4][5][4][2] = 40.2;
        // 40tn 40º 180kt
        brakeEnergy[4][5][5][0] = 37.2;
        brakeEnergy[4][5][5][1] = 42.2;
        brakeEnergy[4][5][5][2] = 48.6;

        // 40tn 50º 80kt
        brakeEnergy[4][6][0][0] = 10.6;
        brakeEnergy[4][6][0][1] = 11.9;
        brakeEnergy[4][6][0][2] = 13.5;
        // 40tn 50º 100kt
        brakeEnergy[4][6][1][0] = 14.9;
        brakeEnergy[4][6][1][1] = 16.8;
        brakeEnergy[4][6][1][2] = 19.1;
        // 40tn 50º 120kt
        brakeEnergy[4][6][2][0] = 19.8;
        brakeEnergy[4][6][2][1] = 22.3;
        brakeEnergy[4][6][2][2] = 25.5;
        // 40tn 50º 140kt
        brakeEnergy[4][6][3][0] = 25.2;
        brakeEnergy[4][6][3][1] = 28.6;
        brakeEnergy[4][6][3][2] = 32.7;
        // 40tn 50º 160kt
        brakeEnergy[4][6][4][0] = 31.1;
        brakeEnergy[4][6][4][1] = 35.3;
        brakeEnergy[4][6][4][2] = 40.6;
        // 40tn 50º 180kt
        brakeEnergy[4][6][5][0] = 37.5;
        brakeEnergy[4][6][5][1] = 42.6;
        brakeEnergy[4][6][5][2] = 49.1;



        // MAX MAN
        adjustedBrakeEnergyNoReverse[0][0] = 7.8;
        adjustedBrakeEnergyNoReverse[0][1] = 16.3;
        adjustedBrakeEnergyNoReverse[0][2] = 25.3;
        adjustedBrakeEnergyNoReverse[0][3] = 34.7;
        adjustedBrakeEnergyNoReverse[0][4] = 44.7;
        adjustedBrakeEnergyNoReverse[0][5] = 55.0;
        adjustedBrakeEnergyNoReverse[0][6] = 65.7;
        adjustedBrakeEnergyNoReverse[0][7] = 76.6;
        adjustedBrakeEnergyNoReverse[0][8] = 87.9;
        // MAX AUTO
        adjustedBrakeEnergyNoReverse[1][0] = 7.5;
        adjustedBrakeEnergyNoReverse[1][1] = 15.4;
        adjustedBrakeEnergyNoReverse[1][2] = 23.6;
        adjustedBrakeEnergyNoReverse[1][3] = 32.4;
        adjustedBrakeEnergyNoReverse[1][4] = 41.8;
        adjustedBrakeEnergyNoReverse[1][5] = 51.8;
        adjustedBrakeEnergyNoReverse[1][6] = 62.5;
        adjustedBrakeEnergyNoReverse[1][7] = 74.1;
        adjustedBrakeEnergyNoReverse[1][8] = 86.5;
        // AUTOBRAKE 3
        adjustedBrakeEnergyNoReverse[2][0] = 7.3;
        adjustedBrakeEnergyNoReverse[2][1] = 14.7;
        adjustedBrakeEnergyNoReverse[2][2] = 22.3;
        adjustedBrakeEnergyNoReverse[2][3] = 30.2;
        adjustedBrakeEnergyNoReverse[2][4] = 38.6;
        adjustedBrakeEnergyNoReverse[2][5] = 47.6;
        adjustedBrakeEnergyNoReverse[2][6] = 57.4;
        adjustedBrakeEnergyNoReverse[2][7] = 68.1;
        adjustedBrakeEnergyNoReverse[2][8] = 80.0;
        // AUTOBRAKE 2
        adjustedBrakeEnergyNoReverse[3][0] = 7.0;
        adjustedBrakeEnergyNoReverse[3][1] = 13.8;
        adjustedBrakeEnergyNoReverse[3][2] = 20.5;
        adjustedBrakeEnergyNoReverse[3][3] = 27.4;
        adjustedBrakeEnergyNoReverse[3][4] = 34.8;
        adjustedBrakeEnergyNoReverse[3][5] = 42.7;
        adjustedBrakeEnergyNoReverse[3][6] = 51.1;
        adjustedBrakeEnergyNoReverse[3][7] = 61.3;
        adjustedBrakeEnergyNoReverse[3][8] = 72.4;
        // AUTOBRAKE 1
        adjustedBrakeEnergyNoReverse[4][0] = 6.7;
        adjustedBrakeEnergyNoReverse[4][1] = 13.1;
        adjustedBrakeEnergyNoReverse[4][2] = 19.2;
        adjustedBrakeEnergyNoReverse[4][3] = 25.3;
        adjustedBrakeEnergyNoReverse[4][4] = 31.8;
        adjustedBrakeEnergyNoReverse[4][5] = 38.8;
        adjustedBrakeEnergyNoReverse[4][6] = 46.6;
        adjustedBrakeEnergyNoReverse[4][7] = 55.4;
        adjustedBrakeEnergyNoReverse[4][8] = 65.5;

        // MAX MAN
        adjustedBrakeEnergySecondDentent[0][0] = 7.0;
        adjustedBrakeEnergySecondDentent[0][1] = 14.6;
        adjustedBrakeEnergySecondDentent[0][2] = 22.8;
        adjustedBrakeEnergySecondDentent[0][3] = 31.4;
        adjustedBrakeEnergySecondDentent[0][4] = 40.5;
        adjustedBrakeEnergySecondDentent[0][5] = 49.9;
        adjustedBrakeEnergySecondDentent[0][6] = 59.7;
        adjustedBrakeEnergySecondDentent[0][7] = 69.8;
        adjustedBrakeEnergySecondDentent[0][8] = 80.0;
        // MAX AUTO
        adjustedBrakeEnergySecondDentent[1][0] = 5.8;
        adjustedBrakeEnergySecondDentent[1][1] = 12.3;
        adjustedBrakeEnergySecondDentent[1][2] = 19.5;
        adjustedBrakeEnergySecondDentent[1][3] = 27.2;
        adjustedBrakeEnergySecondDentent[1][4] = 35.6;
        adjustedBrakeEnergySecondDentent[1][5] = 44.5;
        adjustedBrakeEnergySecondDentent[1][6] = 53.9;
        adjustedBrakeEnergySecondDentent[1][7] = 63.7;
        adjustedBrakeEnergySecondDentent[1][8] = 74.1;
        // AUTOBRAKE 3
        adjustedBrakeEnergySecondDentent[2][0] = 4.3;
        adjustedBrakeEnergySecondDentent[2][1] = 9.2;
        adjustedBrakeEnergySecondDentent[2][2] = 14.7;
        adjustedBrakeEnergySecondDentent[2][3] = 20.7;
        adjustedBrakeEnergySecondDentent[2][4] = 27.2;
        adjustedBrakeEnergySecondDentent[2][5] = 34.4;
        adjustedBrakeEnergySecondDentent[2][6] = 42.0;
        adjustedBrakeEnergySecondDentent[2][7] = 50.2;
        adjustedBrakeEnergySecondDentent[2][8] = 59.0;
        // AUTOBRAKE 2
        adjustedBrakeEnergySecondDentent[3][0] = 2.5;
        adjustedBrakeEnergySecondDentent[3][1] = 5.6;
        adjustedBrakeEnergySecondDentent[3][2] = 9.1;
        adjustedBrakeEnergySecondDentent[3][3] = 13.1;
        adjustedBrakeEnergySecondDentent[3][4] = 17.8;
        adjustedBrakeEnergySecondDentent[3][5] = 23.0;
        adjustedBrakeEnergySecondDentent[3][6] = 28.8;
        adjustedBrakeEnergySecondDentent[3][7] = 35.2;
        adjustedBrakeEnergySecondDentent[3][8] = 42.3;
        // AUTOBRAKE 1
        adjustedBrakeEnergySecondDentent[4][0] = 1.8;
        adjustedBrakeEnergySecondDentent[4][1] = 3.8;
        adjustedBrakeEnergySecondDentent[4][2] = 6.1;
        adjustedBrakeEnergySecondDentent[4][3] = 8.8;
        adjustedBrakeEnergySecondDentent[4][4] = 11.9;
        adjustedBrakeEnergySecondDentent[4][5] = 15.5;
        adjustedBrakeEnergySecondDentent[4][6] = 19.6;
        adjustedBrakeEnergySecondDentent[4][7] = 24.4;
        adjustedBrakeEnergySecondDentent[4][8] = 29.8;

        // Inflight gear down
        coolingTimeSteel[0][0] = 1;
        coolingTimeSteel[0][1] = 2;
        coolingTimeSteel[0][2] = 3;
        coolingTimeSteel[0][3] = 4;
        coolingTimeSteel[0][4] = 5;
        coolingTimeSteel[0][5] = 6;
        // Ground
        coolingTimeSteel[1][0] = 10;
        coolingTimeSteel[1][1] = 20;
        coolingTimeSteel[1][2] = 30;
        coolingTimeSteel[1][3] = 40;
        coolingTimeSteel[1][4] = 50;
        coolingTimeSteel[1][5] = 60;
    }

    double interpolate(double min, double max, double val, double min_val, double max_val){
        double result;

        double interval = max - min;
        double position = (val - min)/interval;
        double range = max_val - min_val;
        double addition = range * position;
        result = min_val + addition;

//        Log.d("BCS", "Interpolando entre " + min + " " + max + " " + val + " y " + min_val + " " + max_val);
//        Log.d("BCS", "Resultado: " + result);

        return result;
    }


    double BrakeEnergy(int weight, int OAT, int speed, int altitude) {
        double result = 0;
        double max_value, min_value;
        int weight_max = 0, weight_min = 0;
        int weight_index = 0;

        if(weight >= 70000){
            weight_index = 0;
            weight_max = 80000;
            weight_min = 70000;
        } else
        if(weight >= 60000 && weight < 70000){
            weight_index = 1;
            weight_max = 70000;
            weight_min = 60000;
        } else
        if(weight >= 50000 && weight < 60000){
            weight_index = 2;
            weight_max = 60000;
            weight_min = 50000;
        } else
        if(weight >= 40000 && weight < 50000){
            weight_index = 3;
            weight_max = 50000;
            weight_min = 40000;
        }

        //Log.d("BCS", "Interpolando entre pesos " + weight_min + " y " + weight_max + " " + OAT + " " + speed + " " + altitude);
        //result = interpolate(weight_min, weight_max, weight, BrakeEnergyWeight(weight_min, OAT, speed, altitude), BrakeEnergyWeight(weight_max, OAT, speed, altitude));

        min_value = BrakeEnergyOAT(weight_index+1, OAT, speed, altitude);
        max_value = BrakeEnergyOAT(weight_index, OAT, speed, altitude);
        result = interpolate(weight_min, weight_max, weight, min_value, max_value);

        //Log.d("BCS", "Minimo: " + weight_min + " valor " + min_value);
        //Log.d("BCS", "Máximo: " + weight_max + " valor " + max_value);
        //result = interpolate(weight_min, weight_max, speed, BrakeEnergyOAT(weight_index+1, OAT, speed, altitude), BrakeEnergyOAT(weight_index, OAT, speed, altitude));
        //Log.d("BCS", "Resultado pesos: " + result);

        return result;
    }



    double BrakeEnergyOAT(int weight_index, int OAT, int speed, int altitude){
        double result = 0, OAT_max = 0, OAT_min = 0;
        int OAT_index = 0;

        if(OAT <= 10){
            OAT_index = 0;
            OAT_max = 10;
            OAT_min = 0;
        } else
        if(OAT > 10 && OAT <= 15){
            OAT_index = 1;
            OAT_max = 15;
            OAT_min = 10;
        } else
        if(OAT > 15 && OAT <= 20){
            OAT_index = 2;
            OAT_max = 20;
            OAT_min = 15;
        } else
        if(OAT > 20 && OAT <= 30){
            OAT_index = 3;
            OAT_max = 30;
            OAT_min = 20;
        } else
        if(OAT > 30 && OAT <= 40){
            OAT_index = 4;
            OAT_max = 40;
            OAT_min = 30;
        } else
        if(OAT > 40 && OAT <= 50){
            OAT_index = 5;
            OAT_max = 50;
            OAT_min = 40;
        }

        //Log.d("BCS", "Interpolando entre temperaturas " + weight_index + " " + OAT_min + " y " + OAT_max + " " + speed + " " + altitude);
        result = interpolate(OAT_min, OAT_max, OAT, BrakeEnergySpeed(weight_index, OAT_index, speed, altitude), BrakeEnergySpeed(weight_index, OAT_index+1, speed, altitude));
        //Log.d("BCS", "Resultado temperaturas: " + result);

        return result;
    }

    double BrakeEnergySpeed(int weight_index, int OAT_index, int speed, int altitude){
        double result = 0, speed_max = 0, speed_min = 0;
        int speed_index = 0;

        if(speed <= 100){
            speed_index = 0;
            speed_max = 100;
            speed_min = 80;
        } else
        if(speed > 100 && speed <= 120){
            speed_index = 1;
            speed_max = 120;
            speed_min = 100;
        } else
        if(speed > 120 && speed <= 140){
            speed_index = 2;
            speed_max = 140;
            speed_min = 120;
        } else
        if(speed > 140 && speed <= 160){
            speed_index = 3;
            speed_max = 160;
            speed_min = 140;
        } else
        if(speed > 160 && speed <= 180){
            speed_index = 4;
            speed_max = 180;
            speed_min = 160;
        }

        //Log.d("BCS", "Interpolando entre velocidades " + weight_index + " " + OAT_index + " " + speed_min + " y " + speed_max + " " + altitude);
        result = interpolate(speed_min, speed_max, speed, BrakeEnergyAltitude(weight_index, OAT_index, speed_index, altitude), BrakeEnergyAltitude(weight_index, OAT_index, speed_index+1, altitude));
        //Log.d("BCS", "Resultado velocidades: " + result);

        return result;
    }

    double BrakeEnergyAltitude(int weight_index, int OAT_index, int speed_index, int altitude){
        double result = 0, altitude_max = 0, altitude_min = 0;
        int altitude_index = 0;

        if(altitude <= 5000){
            altitude_index = 0;
            altitude_max = 5000;
            altitude_min = 0;
        } else
        if(altitude < 5000 && altitude <= 10000){
            altitude_index = 1;
            altitude_max = 10000;
            altitude_min = 5000;
        }

        //Log.d("BCS", "Interpolando entre altitudes " + weight_index + " " + OAT_index + " " + speed_index + " " + altitude_min + " y " + altitude_max);
        result = interpolate(altitude_min, altitude_max, altitude, brakeEnergy[weight_index][OAT_index][speed_index][altitude_index], brakeEnergy[weight_index][OAT_index][speed_index][altitude_index+1]);
        //Log.d("BCS", "Resultado altitudes: " + result);

        return result;
    }

    // General function for obtaining the cooling time. Contains all the steps
    int CoolingTime(int weight, int OAT, int speed, int altitude, int autobrake, boolean reverse, int brakeType){
        int result = 0;

        // Step 1 Get the reference brake energy
        double brakeEnergy = BrakeEnergy(weight, OAT, speed, altitude);
        Log.d("BCS", "Brake Energy: " + brakeEnergy);
        // Step 2 Get the adjusted brake energy
        double adjustedBrakeEnergy = AdjustedBrakeEnergy(brakeEnergy, reverse, autobrake);
        Log.d("BCS", "Adjusted Brake Energy: " + adjustedBrakeEnergy);

        // Step 3 Get the cooling time
        result = CoolingTimeFromEnergy(adjustedBrakeEnergy, brakeType);

        return result;
    }

    double AdjustedBrakeEnergy(double brakeEnergy, boolean reverse, int autobrake){
        double result = 0;
        double brakeEnergy_max = 0, brakeEnergy_min = 0;
        double brakeEnergyVal_min = 0, brakeEnergyVal_max = 0;
        int brakeEnergy_index = 0;

        if(brakeEnergy >= 10 && brakeEnergy <= 20){
            brakeEnergy_max = 20;
            brakeEnergy_min = 10;
            brakeEnergy_index = 0;
        } else
        if(brakeEnergy > 20 && brakeEnergy <= 30){
            brakeEnergy_max = 30;
            brakeEnergy_min = 20;
            brakeEnergy_index = 1;
        } else
        if(brakeEnergy > 30 && brakeEnergy <= 40){
            brakeEnergy_max = 40;
            brakeEnergy_min = 30;
            brakeEnergy_index = 2;
        } else
        if(brakeEnergy > 40 && brakeEnergy <= 50){
            brakeEnergy_max = 50;
            brakeEnergy_min = 40;
            brakeEnergy_index = 3;
        } else
        if(brakeEnergy > 50 && brakeEnergy <= 60){
            brakeEnergy_max = 60;
            brakeEnergy_min = 50;
            brakeEnergy_index = 4;
        } else
        if(brakeEnergy > 60 && brakeEnergy <= 70){
            brakeEnergy_max = 70;
            brakeEnergy_min = 60;
            brakeEnergy_index = 5;
        } else
        if(brakeEnergy > 70 && brakeEnergy <= 80){
            brakeEnergy_max = 80;
            brakeEnergy_min = 70;
            brakeEnergy_index = 6;
        } else
        if(brakeEnergy > 80 && brakeEnergy <= 90){
            brakeEnergy_max = 90;
            brakeEnergy_min = 80;
            brakeEnergy_index = 7;
        }

        if(!reverse){
            brakeEnergyVal_min = adjustedBrakeEnergyNoReverse[autobrake][brakeEnergy_index];
            brakeEnergyVal_max = adjustedBrakeEnergyNoReverse[autobrake][brakeEnergy_index+1];
            Log.d("BCS", "No reverse thrust");
        } else{
            brakeEnergyVal_min = adjustedBrakeEnergySecondDentent[autobrake][brakeEnergy_index];
            brakeEnergyVal_max = adjustedBrakeEnergySecondDentent[autobrake][brakeEnergy_index+1];
            Log.d("BCS", "Second detent");
        }

        result = interpolate(brakeEnergy_min, brakeEnergy_max, brakeEnergy, brakeEnergyVal_min, brakeEnergyVal_max);
        Log.d("BCS", "Interpolating between " + brakeEnergy_min + " - " + brakeEnergy_max + " - " + brakeEnergy + " - " + brakeEnergyVal_min + " - " + brakeEnergyVal_max);

        return result;
    }

    int CoolingTimeFromEnergy(double adjustedBrakeEnergy, int brakeType){
        int result = 0;

        double brakeEnergy_max = 0, brakeEnergy_min = 0;
        int brakeEnergy_index = 0;


        if(adjustedBrakeEnergy < 17) {
            // NO SPECIAL PROCEDURE REQUIRED
            return -1;
        } else
        if(adjustedBrakeEnergy >= 17 && adjustedBrakeEnergy <= 20){
            brakeEnergy_min = 17;
            brakeEnergy_max = 20;
            brakeEnergy_index = 0;
        } else
        if(adjustedBrakeEnergy > 20 && adjustedBrakeEnergy <= 23){
            brakeEnergy_min = 20;
            brakeEnergy_max = 23;
            brakeEnergy_index = 1;
        } else
        if(adjustedBrakeEnergy > 23 && adjustedBrakeEnergy <= 25){
            brakeEnergy_min = 23;
            brakeEnergy_max = 25;
            brakeEnergy_index = 2;
        } else
        if(adjustedBrakeEnergy > 25 && adjustedBrakeEnergy <= 28){
            brakeEnergy_min = 25;
            brakeEnergy_max = 28;
            brakeEnergy_index = 3;
        } else
        if(adjustedBrakeEnergy > 28 && adjustedBrakeEnergy <= 32) {
            brakeEnergy_min = 28;
            brakeEnergy_max = 32;
            brakeEnergy_index = 4;
        } else
        if(adjustedBrakeEnergy > 32 && adjustedBrakeEnergy <= 48) {
            // CAUTION
            return -2;
        } else
        if(adjustedBrakeEnergy > 48) {
            // FUSE PLUG MELT ZONE
            return -3;
        }

        double result_d = interpolate(brakeEnergy_min, brakeEnergy_max, adjustedBrakeEnergy, coolingTimeSteel[1][brakeEnergy_index], coolingTimeSteel[1][brakeEnergy_index+1]);

        result = (int)Math.round(result_d);

        return result;
    }
}
