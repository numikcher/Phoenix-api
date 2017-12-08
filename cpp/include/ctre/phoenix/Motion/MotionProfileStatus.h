#pragma once

#include "ctre/phoenix/Drive/ISmartDrivetrain.h"
#include "ctre/phoenix/Drive/Styles.h"
#include "ctre/phoenix/Stopwatch.h"
#include "ctre/phoenix/Sensors/PigeonIMU.h"
#include "ctre/phoenix/Tasking/ILoopable.h"
#include "ServoParameters.h"
#include "ctre/phoenix/Motion/SetValueMotionProfile.h"
#include "ctre/phoenix/Motion/TrajectoryPoint.h"

namespace CTRE {
namespace Phoenix {
namespace Motion {

/**
 * Motion Profile Status
 * This is simply a data transer object.
 */
struct MotionProfileStatus {
	/**
	 * The available empty slots in the trajectory buffer.
	 *
	 * The robot API holds a "top buffer" of trajectory points, so your applicaion
	 * can dump several points at once.  The API will then stream them into the Talon's
	 * low-level buffer, allowing the Talon to act on them.
	 */
	uint32_t topBufferRem;
	/**
	 * The number of points in the top trajectory buffer.
	 */
	uint32_t topBufferCnt;
	/**
	 * The number of points in the low level Talon buffer.
	 */
	uint32_t btmBufferCnt;
	/**
	 * Set if isUnderrun ever gets set.
	 * Only is cleared by clearMotionProfileHasUnderrun() to ensure
	 * robot logic can react or instrument it.
	 * @see clearMotionProfileHasUnderrun()
	 */
	bool hasUnderrun;
	/**
	 * This is set if Talon needs to shift a point from its buffer into
	 * the active trajectory point however the buffer is empty. This gets cleared
	 * automatically when is resolved.
	 */
	bool isUnderrun;
	/**
	 * True if the active trajectory point has not empty, false otherwise.
	 * The members in activePoint are only valid if this signal is set.
	 */
	bool activePointValid;
	/**
	 * The number of points in the low level Talon buffer.
	 */
	//CTRE::Motion::TrajectoryPoint activePoint;
	/**
	 * The current output mode of the motion profile executer (disabled, enabled, or hold).
	 * When changing the set() value in MP mode, it's important to check this signal to
	 * confirm the change takes effect before interacting with the top buffer.
	 */
	CTRE::Phoenix::Motion::SetValueMotionProfile outputEnable;
};

} // namespace Motion
} // namespace Phoenix
} // namespace CTRE

