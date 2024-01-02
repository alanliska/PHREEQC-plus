package cz.p;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class Spannables extends MainActivity {

    public static Spannable colorized_numbers(final String text) {
        SpannableString spannable = new SpannableString(text);
        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        return spannable;
    }

    public static Spannable colorized_phreeqc(final String text) {
        SpannableString spannable = new SpannableString(text);
        String[] words_red = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-"};
        Integer argb_red = Color.RED;
        for (String word : words_red) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_red),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        String[] words_cyan = {"-ALPHAS ", "-B0 ", "-B1 ", "-B2 ", "-C0 ", "-Eh ", "-Gugg_kJ ", "-Gugg_nondim ", "-LAMDA ", "-MacInnes ", "-Margules ", "-Millero ", "-PSI ", "-THETA ", "-ZETA ", "-active", "-activities", "-activity_coefficients", "-activity_water", "-add_constant", "-add_logk", "-alkalinity", "-all", "-alyotropic_point", "-analytical_expression", "-append", "-axis_scale ", "-axis_titles ", "-bad_step_max ", "-balances ", "-bdot ", "-boundary_conditions ", "-calculate_values", "-capacitance", "-cd_music", "-cells ", "-censor_mp", "-censor_species", "-charge_balance", "-chart_title ", "-co2_coefs ", "-co2_llnl_gamma ", "-comp ", "-comp1 ", "-comp2 ", "-connect_simulations ", "-convergence_tolerance ", "-correct_disp ", "-critical_point ", "-cvode ", "-cvode_order ", "-cvode_steps ", "-davies", "-debug_diffuse_layer ", "-debug_inverse ", "-debug_mass_action ", "-debug_mass_balance ", "-debug_model ", "-debug_prep ", "-debug_set ", "-delta_h ", "-density ", "-description ", "-detach", "-diagonal_scale ", "-diff_c ", "-diffuse_layer ", "-diffusion_coefficient ", "-dispersivities ", "-distribution_coefficients", "-donnan ", "-dump ", "-dump_frequency ", "-dump_restart ", "-dw ", "-echo_input ", "-end ", "-epsilon ", "-equilibrate ", "-equilibrium_phases ", "-erm_ddl ", "-exchange ", "-exchange_gammas ", "-file ", "-fix_current ", "-fixed_pressure", "-fixed_volume", "-flow_direction ", "-force_equality", "-force_solutions", "-formula ", "-gamma", "-gas", "-gas_phase ", "-gases", "-graph_sy ", "-graph_x ", "-graph_y ", "-headings ", "-high_precision ", "-implicit true ", "-initial_isotopes ", "-initial_solutions ", "-initial_time ", "-interlayer_d ", "-inverse_modeling ", "-ionic_strength ", "-isotope ", "-isotope_alphas ", "-isotope_ratios ", "-isotope_uncertainty ", "-isotopes ", "-iterations ", "-kinetic_reactants ", "-kinetics ", "-lengths ", "-lk_phase ", "-lk_species", "-llnl_gamma ", "-log_k ", "-logfile ", "-lon_netpath ", "-m ", "-m0 ", "-mineral_water ", "-minimal ", "-misc1 ", "-misc2 ", "-miscibility_gap ", "-molalities ", "-mole_balance ", "-mp_tolerance ", "-multi_d ", "-multiple_precision ", "-new_line ", "-no_check ", "-no_edl ", "-numerical_fixed_volume ", "-numerical_derivatives ", "-omega", "-only_counter_ions ", "-osmotic", "-other ", "-p_c", "-parms ", "-pat_netpath", "-pe_step_size ", "-percent_error", "-phases", "-pitzer_exchange_gammas", "-plot_concentration_vs", "-plot_tsv_file ", "-potential ", "-pressure", "-print_cells", "-print_frequency", "-punch_cells", "-punch_frequency", "-porosities", "-range", "-reaction ", "-reaction_pressure ", "-reaction_temperature ", "-redox", "-reset ", "-runge_kutta ", "-same_model ", "-saturation_indices ", "-shifts ", "-simulation ", "-sites_units ", "-solid_solutions ", "-solution ", "-solutions", "-species", "-spinodal_gap", "-stagnant ", "-start", "-start_time ", "-state", "-status false", "-steps ", "-step_divide ", "-step_no ", "-step_size ", "-steps ", "-surface", "-t_c", "-temp ", "-temperature ", "-tempk ", "-thermal_diffusion ", "-time ", "-time_step ", "-tol ", "-tolerance ", "-total_time ", "-totals ", "-uncertainty ", "-uncertainty_water ", "-units ", "-use_etheta ", "-user_graph ", "-user_print ", "-user_punch ", "-volume ", "-viscosity ", "-warnings ", "-water", "ACT", "ALK ", "Alkalinity ", "APHI ", "Black ", "Blue ", "Brown ", "CEIL", "CELL_NO ", "CHANGE_POR", "CHANGE_SURF", "CHARGE_BALANCE", "CHR$", "Circle ", "Color = ", "CURRENT_A", "Cyan ", "DATA ", "DESCRIPTION ", "DH_A ", "DH_AV ", "DH_B ", "Diamond ", "DIFF_C ", "DIST ", "DUMP", "EDL", "EDL_SPECIES", "EOL$", "EPS_R", "EQUI", "EXISTS", "FLOOR", "FOR ", "NEXT ", "GAMMA", "GAS", "GAS_P", "GAS_VM", "GET", "GET_POR", "GFW", "GOSUB ", "GOTO ", "GRAPH_SY ", "GRAPH_X ", "GRAPH_Y ", "Green ", "HDash ", "KAPPA", "KIN", "KINETICS", "KINETICS_MIX", "KINETICS_FORMULA$", "KINETICS_MODIFY", "KIN_DELTA", "KIN_TIME", "LA", "LG", "LIST_S_S", "LK_NAMED ", "LK_PHASE ", "LK_SPECIES", "LLNL_AQUEOUS_MODEL_PARAMETERS", "LM", "LOG", "LOG10", "Lavender ", "LightSeaGreen ", "M ", "M0 ", "MCD_JCONC", "MCD_JTOT", "MISC1", "MISC2", "MOL", "MU", "Magenta ", "None ", "Orange ", "OSMOTIC", "PARM", "PERCENT_ERROR ", "PHASE_FORMULA$", "PHASE_VM", "PLOT_XY ", "POT_V", "PRESSURE", "PRINT", "PR_P", "PR_PHI", "PUNCH ", "PUT", "Plus ", "READ ", "RESTORE ", "RETURN ", "RHO", "RHO_0", "RXN", "Red ", "RoyalBlue ", "SC", "SI", "SIM_NO", "SIM_TIME", "SIT", "SOLN_VOL ", "SR", "STEP ", "STEP_NO", "STR_E$", "STR_F$", "STR$", "SUM_GAS", "SUM_S_S", "SUM_SPECIES", "SURF", "SYS", "S_S", "Square ", "Star ", "TC", "THETA", "TIME ", "TK", "TOT", "TOTAL_TIME", "TOTMOLE", "TRIM", "TRIM(STR$(", "Teal ", "Thompson ", "Tomato ", "Triangle ", "TriangleDown ", "VDash ", "VISCOS ", "VISCOS_0 ", "WEND ", "WHILE ", "XCross ", "Yellow ", "ZETA ", "act", "active false", "active true", "activities", "activity_coefficients", "activity_water", "add_constant", "add_logk", "alk", "alkalinity", "alyotropic_point", "analytical_expression", "aphi ", "auto", "axis_scale ", "axis_titles ", "backward", "bad_step_max ", "balances ", "bdot ", "boundary_conditions ", "calc_value", "calculate", "calculate_values", "capacitance", "cd_music", "ceil", "cell_no ", "cell ", "cells ", "censor_mp", "censor_species", "change_por", "change_surf", "charge", "charge_balance", "chart_title ", "chr$", "closed", "co2_coefs ", "co2_llnl_gamma ", "color = ", "comp ", "comp1 ", "comp2 ", "connect_simulations ", "constant", "convergence_tolerance ", "correct_disp ", "correct_GC ", "critical_point ", "current_a", "cvode ", "cvode_order ", "cvode_steps ", "davies", "debug_diffuse_layer ", "debug_inverse ", "debug_mass_action ", "debug_mass_balance ", "debug_model ", "debug_prep ", "debug_set ", "debye_length ", "delta_h ", "delta_h_phase", "delta_h_species", "density", "description ", "detach", "detach", "diagonal_scale ", "dh_a0", "dh_bdot", "diffuse_layer ", "diffusion_coefficient ", "diffusion_only", "diff_c", "dispersivities ", "dist ", "distance ", "distribution_coefficients", "donnan ", "dump ", "dump_frequency ", "dump_restart ", "dw ", "echo_input ", "edl", "edl_species", "end ", "eol$ ", "eol_notab$ ", "eps_r ", "equi", "equilibrate ", "equilibrium_phases ", "erm_ddl ", "exchange ", "exchange_gammas ", "exists", "false", "file ", "fix_current ", "fixed_pressure", "fixed_volume", "floor", "flow_direction ", "flux ", "force_equality", "force_solutions", "formula ", "forward", "gamma", "gas", "gas_p ", "gas_phase ", "gas_vm", "gases", "get", "get_por", "gfw", "gosub ", "goto ", "graph_sy ", "graph_x ", "graph_y ", "headings ", "high_precision ", "implicit true ", "initial_isotopes ", "initial_solutions ", "initial_time ", "interlayer_d ", "inverse_modeling ", "ionic_strength ", "isotope ", "isotope_alphas ", "isotope_ratios ", "isotope_uncertainty ", "isotopes ", "iterations ", "kappa", "kin_delta", "kin_time", "kin", "kinetic_reactants ", "kinetics ", "kinetics_formula$ ", "la ", "lengths", "lg", "line_width = ", "lk_phase ", "lk_species", "llnl_gamma ", "lm", "log", "log10", "log_k ", "logfile ", "lon_netpath ", "m ", "m0 ", "mineral_water ", "minimal ", "misc1 ", "misc2 ", "miscibility_gap ", "mol", "molalities ", "mole_balance ", "mp_tolerance ", "mu", "multi_d ", "multiple_precision ", "new_line ", "no_check", "no_edl ", "no_newlines ", "numerical_fixed_volume ", "numerical_derivatives ", "only_counter_ions ", "osmotic", "other ", "pH ", "p_c", "parm", "parms ", "pat_netpath", "pe ", "pe_step_size ", "percent_error", "phase_formula$", "phase_vm", "phases", "pitzer.dat", "pitzer_exchange_gammas", "plot_concentration_vs ", "plot_csv_file ", "plot_xy ", "pot_v", "potential ", "pressure", "print", "print_cells", "print_frequency", "punch", "punch_cells", "punch_frequency", "put ", "porosities", "qbrn", "range", "reaction ", "reaction_pressure ", "reaction_temperature ", "read ", "redox", "reset ", "restore ", "rho", "rho_0", "runge_kutta ", "rxn", "s_s", "same_model ", "saturation_indices ", "save", "sc", "shifts ", "set_diff_c", "si ", "sim_no ", "sim_time ", "simulation", "sites_units", "solid_solutions ", "soln_vol ", "solution ", "solutions", "species", "spinodal_gap", "sr", "stagnant ", "start", "start_time ", "state", "status", "steps ", "step_divide ", "step_no ", "step_size ", "steps ", "str_e$", "str_f$", "str$", "sum_gas", "sum_s_s", "sum_species", "surf", "surface", "symbol = ", "symbol_size = ", "sys", "sy_axis ", "t_c ", "tc ", "temp ", "temperature ", "tempk ", "thermal_diffusion ", "time ", "time_step ", "tk ", "tol ", "tolerance ", "tot", "total_time ", "totals ", "totmole", "trim", "trim(str$(", "true", "uncertainty", "uncertainty_water", "units ", "use_etheta ", "user_graph", "user_print", "user_punch", "viscos ", "viscos_0 ", "vm", "volume", "warnings ", "water", "wend ", "while ", "x_axis ", "y_axis "};
        Integer argb_cyan = Color.CYAN;
        for (String word : words_cyan) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_cyan),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        String[] words_blue = {"ADVECTION", "CALCULATE_VALUES", "COPY", "DATABASE", "DELETE", "DUMP", "END", "EQUILIBRIUM_PHASES", "EXCHANGE", "EXCHANGE_MASTER_SPECIES", "EXCHANGE_SPECIES", "GAS_PHASE", "INCLUDE$", "INCREMENTAL_REACTIONS", "INVERSE_MODELING", "ISOTOPES", "ISOTOPE_ALPHAS", "ISOTOPE_RATIOS", "KINETICS", "KNOBS", "LLNL_AQUEOUS_MODEL_PARAMETERS", "MIX", "NAMED_EXPRESSIONS", "PHASES", "PITZER", "PRINT", "RATES", "REACTION", "REACTION_PRESSURE", "REACTION_TEMPERATURE", "RUN_CELLS", "SAVE", "SELECTED_OUTPUT", "SIT", "SOLID_SOLUTIONS", "SOLUTION", "SOLUTION_MASTER_SPECIES", "SOLUTION_SPECIES", "SOLUTION_SPREAD", "SURFACE", "SURFACE_MASTER_SPECIES", "SURFACE_SPECIES", "TITLE", "TRANSPORT", "USE", "USER_GRAPH", "USER_PRINT", "USER_PUNCH", "EQUILIBRIUM_PHASES_MODIFY", "EXCHANGE_MODIFY", "GAS_PHASE_MODIFY", "KINETICS_MODIFY", "REACTION_MODIFY", "SOLID_SOLUTIONS_MODIFY", "SOLUTION_MODIFY", "SURFACE_MODIFY"};
        Integer argb_blue = Color.BLUE;
        for (String word : words_blue) {
            int substringStart=0;
            int start;
            while((start=text.indexOf(word,substringStart))>=0){
                spannable.setSpan(
                        new ForegroundColorSpan(argb_blue),start,start+word.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                substringStart = start+word.length();
            }
        }

        return spannable;
    }

}
