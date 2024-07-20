//
//  AboutListView.swift
//  iosApp
//
//  Created by Otamurod Safarov on 15/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct AboutListView: View {
    let items: [AboutViewModel.RowItem]

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView(items: [AboutViewModel.RowItem(title: "Title", subtitle: "Subtitle")])
}
