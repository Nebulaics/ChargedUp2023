package frc.team2412.robot.util.auto;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

public class AutonomousChooser {
	public interface CommandSupplier {
		Command getCommand();
	}

	private final SendableChooser<CommandSupplier> autonomousModeChooser = new SendableChooser<>();

	public AutonomousChooser() {
		autonomousModeChooser.setDefaultOption(
				"BottomCommunity", () -> AutonomousTrajectories.getBotCommunityAutoPath());
		autonomousModeChooser.addOption(
				"ChargeStation", () -> AutonomousTrajectories.getChargedAutoPath());
		autonomousModeChooser.addOption(
				"TopCommunity", () -> AutonomousTrajectories.getTopCommunityAutoPath());
		autonomousModeChooser.addOption("TopScore", () -> AutonomousTrajectories.getTopScoreAutoPath());
		autonomousModeChooser.addOption("BotScore", () -> AutonomousTrajectories.getBotScoreAutoPath());

		ShuffleboardTab autonomousTab = Shuffleboard.getTab("Autonomous");

		autonomousTab.add("Choose Auto Mode", autonomousModeChooser).withPosition(0, 0).withSize(2, 1);
	}

	public Command getAuto() {
		return autonomousModeChooser.getSelected().getCommand();
	}
}