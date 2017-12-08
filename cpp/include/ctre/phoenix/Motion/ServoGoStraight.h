#pragma once

#include "ctre/phoenix/Drive/ISmartDrivetrain.h"
#include "ctre/phoenix/Drive/Styles.h"
#include "ctre/phoenix/Stopwatch.h"
#include "ctre/phoenix/Tasking/ILoopable.h"
#include "ServoParameters.h"

namespace CTRE {
namespace Phoenix {
namespace Motion {

class ServoGoStraight: public CTRE::Phoenix::Tasking::ILoopable {
public:
	ServoParameters *servoParameters = new ServoParameters();
	ServoGoStraight(CTRE::Phoenix::Drive::ISmartDrivetrain *driveTrain,
			CTRE::Phoenix::Drive::Styles::Smart selectedStyle, ServoParameters *params,
			float Y, float targetHeading, float headingTolerance,
			float maxOutput);
	ServoGoStraight(CTRE::Phoenix::Drive::ISmartDrivetrain *driveTrain,
			CTRE::Phoenix::Drive::Styles::Smart selectedStyle);
	bool Set(float Y, float targetHeading, float headingTolerance,
			float maxOutput);
	float GetEncoderHeading();
	void OnStart();
	void OnStop();
	bool IsDone();
	void OnLoop();

private:
	CTRE::Phoenix::Drive::ISmartDrivetrain *_driveTrain;
	CTRE::Phoenix::Drive::Styles::Smart _selectedStyle;
	CTRE::Phoenix::Stopwatch *_myStopWatch = new CTRE::Phoenix::Stopwatch();
	float _Y;
	float _targetHeading;
	float _headingTolerance;
	float _previousHeading;
	float _timeElapsed;
	float _maxOutput;
	bool _isRunning = false;
	bool _isDone = false;
	unsigned char _state = 0;

	bool GoStraight(float Y, float targetHeading, float headingTolerance);
};

} // namespace Motion
} // namespace Phoenix
} // namespace CTRE
