import Shared
import SwiftUI

struct RemindersView: View {
    @StateObject private var viewModelWrapper = RemindersViewModelWrapper()
    @State private var textFieldValue = ""

    var body: some View {
        List {
            if !viewModelWrapper.reminders.isEmpty {
                Section {
                    ForEach(viewModelWrapper.reminders, id: \.id) { item in
                        ReminderItem(title: item.title, isCompleted: item.isCompleted)
                            .onTapGesture {
                                withAnimation {
                                    viewModelWrapper.viewModel.markReminder(id: item.id, isCompleted: !item.isCompleted)
                                }
                            }.contextMenu {
                                Button(role: .destructive) {
                                    withAnimation {
                                        viewModelWrapper.viewModel.deleteReminder(reminder: item)
                                    }
                                } label: {
                                    Label("Delete", systemImage: "trash")
                                }
                            }
                            .swipeActions(
                                edge: .trailing,
                                allowsFullSwipe: true
                            ) {
                                Button(role: .destructive) {
                                    withAnimation {
                                        viewModelWrapper.viewModel.deleteReminder(reminder: item)
                                    }
                                } label: {
                                    Label("Delete", systemImage: "trash")
                                }
                            }
                    }
                }
            }
            Section {
                NewReminderTextField(text: $textFieldValue) {
                    withAnimation {
                        viewModelWrapper.viewModel.createReminder(title: textFieldValue)
                        textFieldValue = ""
                    }
                }
            }
        }.navigationTitle("Reminders")
    }
}

struct RemindersView_Previews: PreviewProvider {
    static var previews: some View {
        RemindersView()
    }
}
