package com.ctre.phoenix.MotorControl.CAN;
import com.ctre.phoenix.MotorControl.*;


public class MotControllerJNI extends CTREJNIWrapper {
	
    public static native long Create(int baseArbId);
	/**
   * Returns the Device ID
   *
   * @return  Device number.   */
	public static native int GetDeviceNumber(long handle);
  /**
   * Sets the demand (output) of the motor controller.
   *
   * @param mode    Control Mode of the Motor Controller
   * @param demand0 Primary Demand value
   * @param demand1 Secondary Demand value
   **/
	public static native void SetDemand(long handle, int mode, int demand0, int demand1);
  /**
   * Sets the mode of operation during neutral throttle output.
   *
   * @param neutralMode The desired mode of operation when the Controller output throttle is neutral (ie brake/coast)
   **/
	public static native void SetNeutralMode(long handle, int neutralMode);
  /**
   * Sets the phase of the sensor.  Use when controller forward/reverse output doesn't 
correlate to appropriate forward/reverse reading of sensor.
   *
   * @param PhaseSensor Indicates whether to invert the phase of the sensor.
   **/
	public static native void SetSensorPhase(long handle, boolean PhaseSensor);
  /**
   * Inverts the output of the motor controller.  LEDs, sensor phase,
and limit switches will also be inverted to match the new 
forward/reverse directions.
   *
   * @param invert Invert state to set.
   **/
	public static native void SetInverted(long handle, boolean invert);
  /**
   * Configures the open-loop ramp rate of throttle output.
   *
   * @param secondsFromNeutralToFull Minimum desired time to go from neutral to full throttle.  A value of '0' will disable the ramp.
   * @param timeoutMs                Timeout value in ms.  Function will generate error if config is not successful within timeout.
   * @return                          Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigOpenLoopRamp(long handle, float secondsFromNeutralToFull, int timeoutMs);
  /**
   * Configures the closed-loop ramp rate of throttle output.
   *
   * @param secondsFromNeutralToFull Minimum desired time to go from neutral to full throttle.  A value of '0' will disable the ramp.
   * @param timeoutMs                Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                          Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigClosedLoopRamp(long handle, float secondsFromNeutralToFull, int timeoutMs);
  /**
   * Configures the forward peak output percentage.
   *
   * @param percentOut Desired peak output percentage.
   * @param timeoutMs  Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return            Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigPeakOutputForward(long handle, float percentOut, int timeoutMs);
  /**
   * Configures the reverse peak output percentage.
   *
   * @param percentOut Desired peak output percentage.
   * @param timeoutMs  Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return            Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigPeakOutputReverse(long handle, float percentOut, int timeoutMs);
  /**
   * Configures the forward nominal output percentage.
   *
   * @param percentOut Nominal (minimum) percent output.
   * @param timeoutMs  Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return            Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigNominalOutputForward(long handle, float percentOut, int timeoutMs);
  /**
   * Configures the reverse nominal output percentage.
   *
   * @param percentOut Nominal (minimum) percent output.
   * @param timeoutMs  Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return            Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigNominalOutputReverse(long handle, float percentOut, int timeoutMs);
  /**
   * Configures the output deadband percentage.
   *
   * @param percentDeadband Desired deadband percentage.  Minimum is 0.1%, Maximum is 25%.
   * @param timeoutMs       Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                 Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigNeutralDeadband(long handle, float percentDeadband, int timeoutMs);
  /**
   * Configures the Voltage Compensation saturation voltage.
   *
   * @param voltage    TO-DO: Comment me!
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigVoltageCompSaturation(long handle, float voltage, int timeoutMs);
  /**
   * Configures the voltage measurement filter.
   *
   * @param filterWindowSamples Number of samples in the rolling average of voltage measurement.
   * @param timeoutMs           Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                     Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigVoltageMeasurementFilter(long handle, int filterWindowSamples, int timeoutMs);
  /**
   * Enables voltage compensation.  If enabled, voltage compensation works in all control modes.
   *
   * @param enable Enable state of voltage compensation.
   **/
	public static native void EnableVoltageCompensation(long handle, boolean enable);
  /**
   * Gets the bus voltage seen by the motor controller.
   *
   * @return         The bus voltage value (in volts).   */
	public static native float GetBusVoltage(long handle);
  /**
   * Gets the output percentage of the motor controller.
   *
   * @return        Output of the motor controller (in percent).   */
	public static native float GetMotorOutputPercent(long handle);
  /**
   * Gets the output current of the motor controller.
   *
   * @return        Output current (in amps).   */
	public static native float GetOutputCurrent(long handle);
  /**
   * Gets the temperature of the motor controller.
   *
   * @return            The temperature of the motor controller (in �C)   */
	public static native float GetTemperature(long handle);
  /**
   * Configures the remote feedback filter.
   *
   * @param arbId         ArbId of device.
   * @param peripheralIdx Peripheral index.
   * @param reserved      Reserved.
   * @param timeoutMs     Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return               Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigRemoteFeedbackFilter(long handle, int arbId, int peripheralIdx, int reserved, int timeoutMs);
  /**
   * Select the feedback device for the motor controller.
   *
   * @param feedbackDevice Feedback Device to select.
   * @param timeoutMs      Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigSelectedFeedbackSensor(long handle, int feedbackDevice, int timeoutMs);
  /**
   * Get the selected sensor position.
   *
   * @return      Position of selected sensor (in Raw Sensor Units).   */
	public static native int GetSelectedSensorPosition(long handle);
  /**
   * Get the selected sensor velocity.
   *
   * @return      Velocity of selected sensor (in Raw Sensor Units per 100 ms).   */
	public static native int GetSelectedSensorVelocity(long handle);
  /**
   * Sets the sensor position to the given value.
   *
   * @param sensorPos Position to set for the selected sensor (in Raw Sensor Units).
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int SetSelectedSensorPosition(long handle, int sensorPos, int timeoutMs);
  /**
   * Sets the period of the given control frame.
   *
   * @param frame    Frame whose period is to be changed.
   * @param periodMs Period in ms for the given frame.
   * @return          Error Code generated by function.  0 indicates no error.   */
	public static native int SetControlFramePeriod(long handle, int frame, int periodMs);
  /**
   * Sets the period of the given status frame.
   *
   * @param frame     Frame whose period is to be changed.
   * @param periodMs  Period in ms for the given frame.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int SetStatusFramePeriod(long handle, int frame, int periodMs, int timeoutMs);
  /**
   * Gets the period of the given status frame.
   *
   * @param frame     Frame to get the period of.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return          The period of the given status frame.   */
	public static native int GetStatusFramePeriod(long handle, int frame, int timeoutMs);
  /**
   * Sets the period over which velocity measurements are taken.
   *
   * @param period    Desired period for the velocity measurement. @see #VelocityMeasPeriod
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigVelocityMeasurementPeriod(long handle, int period, int timeoutMs);
  /**
   * Sets the number of velocity samples used in the rolling average velocity measurement.
   *
   * @param windowSize Number of samples in the rolling average of velocity measurement.
   * @param timeoutMs  Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return            Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigVelocityMeasurementWindow(long handle, int windowSize, int timeoutMs);
  /**
   * Configures the forward limit switch for a remote source.
   *
   * @param type              Remote limit switch source. @see #LimitSwitchSource
   * @param normalOpenOrClose Setting for normally open or normally closed.
   * @param deviceID          Device ID of remote source.
   * @param timeoutMs         Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                   Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigForwardLimitSwitchSource(long handle, int type, int normalOpenOrClose, int deviceID, int timeoutMs);
  /**
   * Configures the reverse limit switch for a remote source.
   *
   * @param type              Remote limit switch source. @see #LimitSwitchSource
   * @param normalOpenOrClose Setting for normally open or normally closed.
   * @param deviceID          Device ID of remote source.
   * @param timeoutMs         Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                   Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigReverseLimitSwitchSource(long handle, int type, int normalOpenOrClose, int deviceID, int timeoutMs);
  /**
   * Sets the enable state for limit switches.
   *
   * @param enable Enable state for limit switches.
   **/
	public static native void EnableLimitSwitches(long handle, boolean enable);
  /**
   * Configures the forward soft limit.
   *
   * @param forwardSensorLimit Forward Sensor Position Limit (in Raw Sensor Units).
   * @param timeoutMs          Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                    Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigForwardSoftLimit(long handle, int forwardSensorLimit, int timeoutMs);
  /**
   * Configures the reverse soft limit.
   *
   * @param reverseSensorLimit Reverse Sensor Position Limit (in Raw Sensor Units).
   * @param timeoutMs          Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                    Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigReverseSoftLimit(long handle, int reverseSensorLimit, int timeoutMs);
  /**
   * Sets the enable state for soft limit switches.
   *
   * @param enable Enable state for soft limit switches.
   **/
	public static native void EnableSoftLimits(long handle, boolean enable);
  /**
   * Sets the 'P' constant in the given parameter slot.
   *
   * @param slotIdx   Parameter slot for the constant.
   * @param value     Value of the P constant.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int Config_kP(long handle, int slotIdx, float value, int timeoutMs);
  /**
   * Sets the 'I' constant in the given parameter slot.
   *
   * @param slotIdx   Parameter slot for the constant.
   * @param value     Value of the I constant.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int Config_kI(long handle, int slotIdx, float value, int timeoutMs);
  /**
   * Sets the 'D' constant in the given parameter slot.
   *
   * @param slotIdx   Parameter slot for the constant.
   * @param value     Value of the D constant.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int Config_kD(long handle, int slotIdx, float value, int timeoutMs);
  /**
   * Sets the 'F' constant in the given parameter slot.
   *
   * @param slotIdx   Parameter slot for the constant.
   * @param value     Value of the F constant.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int Config_kF(long handle, int slotIdx, float value, int timeoutMs);
  /**
   * Sets the Integral Zone constant in the given parameter slot.
   *
   * @param slotIdx   Parameter slot for the constant.
   * @param izone     Value of the Integral Zone constant.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int Config_IntegralZone(long handle, int slotIdx, float izone, int timeoutMs);
  /**
   * Sets the allowable closed-loop error in the given parameter slot.
   *
   * @param slotIdx                  Parameter slot for the constant.
   * @param allowableClosedLoopError Value of the allowable closed-loop error.
   * @param timeoutMs                Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                          Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigAllowableClosedloopError(long handle, int slotIdx, int allowableClosedLoopError, int timeoutMs);
  /**
   * Sets the maximum integral accumulator in the given parameter slot.
   *
   * @param slotIdx   Parameter slot for the constant.
   * @param iaccum    Value of the maximum integral accumulator.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigMaxIntegralAccumulator(long handle, int slotIdx, float iaccum, int timeoutMs);
  /**
   * Sets the integral accumulator.
   *
   * @param iaccum    Value to set for the integral accumulator.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int SetIntegralAccumulator(long handle, float iaccum, int timeoutMs);
  /**
   * Gets the closed-loop error.
   *
   * @param slotIdx         Parameter slot of the constant.
   * @return                Closed-loop error value.   */
	public static native int GetClosedLoopError(long handle, int slotIdx);
  /**
   * Gets the iaccum value.
   *
   * @param slotIdx Parameter slot of the constant.
   * @return        Integral accumulator value.   */
	public static native float GetIntegralAccumulator(long handle, int slotIdx);
  /**
   * Gets the derivative of the closed-loop error.
   *
   * @param slotIdx Parameter slot of the constant.
   * @return        Error derivative value.   */
	public static native float GetErrorDerivative(long handle, int slotIdx);
  /**
   * Selects which profile slot to use for closed-loop control.
   *
   * @param slotIdx Profile slot to select.
   **/
	public static native void SelectProfileSlot(long handle, int slotIdx);
  /**
   * Sets the Motion Magic Cruise Velocity.
   *
   * @param sensorUnitsPer100ms Motion Magic Cruise Velocity (in Raw Sensor Units per 100 ms).
   * @param timeoutMs           Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                     Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigMotionCruiseVelocity(long handle, int sensorUnitsPer100ms, int timeoutMs);
  /**
   * Sets the Motion Magic Acceleration.
   *
   * @param sensorUnitsPer100msPerSec Motion Magic Acceleration (in Raw Sensor Units per 100 ms per second).
   * @param timeoutMs                 Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return                           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigMotionAcceleration(long handle, int sensorUnitsPer100msPerSec, int timeoutMs);
  /**
   * Gets the last error generated by this object.
   *
   * @return  Last Error Code generated by a function.   */
	public static native int GetLastError(long handle);
  /**
   * Gets the firmware version of the device.
   *
   * @return  Firmware version of device.   */
	public static native int GetFirmwareVersion(long handle);
  /**
   * Returns true if the device has reset.
   *
   * @return  Has a Device Reset Occurred?   */
	public static native boolean HasResetOccurred(long handle);
  /**
   * Sets the value of a custom parameter.
   *
   * @param newValue   Value for custom parameter.
   * @param paramIndex Index of custom parameter.
   * @param timeoutMs  Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return            Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigSetCustomParam(long handle, int newValue, int paramIndex, int timeoutMs);
  /**
   * Gets the value of a custom parameter.
   *
   * @param paramIndex Index of custom parameter.
   * @param timoutMs   Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Value of the custom param.   */
	public static native int ConfigGetCustomParam(long handle, int paramIndex, int timoutMs);
  /**
   * Sets a parameter.
   *
   * @param param     Parameter enumeration.
   * @param value     Value of parameter.
   * @param subValue  Subvalue for parameter.  Maximum value of 255.
   * @param ordinal   Ordinal of parameter.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigSetParameter(long handle, int param, float value, int subValue, int ordinal, int timeoutMs);
  /**
   * Gets a parameter.
   *
   * @param param     Parameter enumeration.
   * @param ordinal   Ordinal of parameter.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return          Value of parameter.   */
	public static native float ConfigGetParameter(long handle, int param, int ordinal, int timeoutMs);
  /**
   * Configures the peak current limit of the motor controller.
   *
   * @param amps      Peak current limit (in amps).
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigPeakCurrentLimit(long handle, int amps, int timeoutMs);
  /**
   * Configures the maximum time allowed at peak current limit of the motor controller.
   *
   * @param milliseconds Maximum time allowed at peak current limit (in milliseconds).
   * @param timeoutMs    Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return              Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigPeakCurrentDuration(long handle, int milliseconds, int timeoutMs);
  /**
   * Configures the continuous current limit.
   *
   * @param amps      Continuous Current Limit.
   * @param timeoutMs Timeout value in ms.  @see #ConfigOpenLoopRamp
   * @return           Error Code generated by function.  0 indicates no error.   */
	public static native int ConfigContinuousCurrentLimit(long handle, int amps, int timeoutMs);
  /**
   * Enables the current limit feature.
   *
   * @param enable Enable state of current limit.
   **/
	public static native void EnableCurrentLimit(long handle, boolean enable);
}